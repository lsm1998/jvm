/*
 * 作者：刘时明
 * 时间：2019/12/15-12:51
 * 作用：配置解析类
 */
package com.lsm1998.jvm.config;

import com.lsm1998.jvm.config.define.Modes;
import com.lsm1998.jvm.util.ArraysUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class CmdParse
{
    private String[] args;
    private static final String[] defaultArgs;
    private volatile static CmdParse parse;
    private static final Lock lock = new ReentrantLock();

    static
    {
        try
        {
            // 加载元配置
            Class.forName("com.lsm1998.jvm.config.MataConfig");
            // 加载本地方法
            Class.forName("com.lsm1998.jvm.natives.NativeRegistry");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        defaultArgs = new String[]{"null", Modes.AUTH.mode(), "jvm.yml"};
    }

    public static CmdParse getInstance(String[] args)
    {
        try
        {
            lock.lock();
            if (parse == null)
            {
                parse = new CmdParse(args);
            }
            return parse;
        } finally
        {
            lock.unlock();
        }
    }

    private CmdParse(String[] args)
    {
        if (ArraysUtil.isEmpty(args))
        {
            this.args = defaultArgs;
        }
        this.args = checkArgs(args);
    }

    private String[] checkArgs(String[] args)
    {
        if (args.length <= 3)
        {
            return makeUpArgs(args);
        } else
        {
            log.error("args参数长度最多为3，你的长度是{}", args.length);
            throw new RuntimeException("args参数长度错误");
        }
    }

    private String[] makeUpArgs(String[] args)
    {
        String[] temp = new String[defaultArgs.length];
        for (int i = 0; i < defaultArgs.length; i++)
        {
            if (i < args.length)
            {
                temp[i] = args[i];
            } else
            {
                temp[i] = defaultArgs[i];
            }
        }
        return temp;
    }

    public String[] args()
    {
        return this.args;
    }
}

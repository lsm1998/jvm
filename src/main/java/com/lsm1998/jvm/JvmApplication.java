/*
 * 作者：刘时明
 * 时间：2019/12/15-12:48
 * 作用：启动类
 */
package com.lsm1998.jvm;

import com.lsm1998.jvm.config.CmdParse;
import com.lsm1998.jvm.config.define.JvmStarter;
import com.lsm1998.jvm.config.define.Modes;
import com.lsm1998.jvm.config.start.StarterBuilder;
import com.lsm1998.jvm.test.Hello;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JvmApplication
{
    public static void main(String[] args)
    {
        // 1.CMD命令解析
        CmdParse parse = CmdParse.getInstance(args);
        // 2.构造JVM启动器
        JvmStarter starter = new StarterBuilder()
                .parse(parse)
                .hello("我的JVM")
                // 指定执行的class对象
                .classObj(Hello.class)
                // 指定执行的class文件路径
                // .classPath("C:\\Users\\Admin\\IdeaProjects\\jvm\\target\\test-classes\\Hello.class")
                // 指定模式为运行
                .mode(Modes.RUN)
                // 操作数栈最大深度
                .maxStack(512)
                .build();
        // 3.启动
        starter.start();
    }
}

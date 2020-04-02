/*
 * 作者：刘时明
 * 时间：2019/12/15-15:46
 * 作用：
 */
package com.lsm1998.jvm.config.start;

import com.lsm1998.jvm.config.CmdParse;
import com.lsm1998.jvm.config.ConfigParse;
import com.lsm1998.jvm.config.JvmConfig;
import com.lsm1998.jvm.config.define.Modes;
import com.lsm1998.jvm.utils.YmlUtil;

public class StarterBuilder
{
    private final JvmConfig config;

    public StarterBuilder()
    {
        this.config = new JvmConfig();
    }

    public StarterBuilder parse(CmdParse parse)
    {
        this.config.setClassPath(parse.args()[0]);
        this.config.setMode(Modes.valueOf(parse.args()[1]));
        this.config.setConfName(parse.args()[2]);
        ConfigParse.parseByMap(YmlUtil.loadYml(parse.args()[2]), this.config);
        return this;
    }

    public StarterBuilder hello(String hello)
    {
        config.setHello(hello);
        return this;
    }

    public StarterBuilder classObj(Class<?> obj)
    {
        config.setClassObj(obj);
        return this;
    }

    public StarterBuilder classPath(String classPath)
    {
        config.setClassPath(classPath);
        return this;
    }

    public StarterBuilder confName(String confName)
    {
        config.setConfName(confName);
        return this;
    }

    public StarterBuilder maxStack(Integer maxStack)
    {
        config.setMaxStack(maxStack);
        return this;
    }

    public StarterBuilder mode(Modes mode)
    {
        config.setMode(mode);
        return this;
    }

    public JvmStarterImpl build()
    {
        return new JvmStarterImpl(this);
    }

    public JvmConfig getConfig()
    {
        return this.config;
    }
}

/*
 * 作者：刘时明
 * 时间：2019/12/15-16:41
 * 作用：启动器
 */
package com.lsm1998.jvm.config.define;

public interface JvmStarter
{
    Config jvmConfig();

    void start();

    void stop();
}

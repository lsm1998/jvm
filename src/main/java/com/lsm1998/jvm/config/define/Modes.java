/*
 * 作者：刘时明
 * 时间：2019/12/15-14:53
 * 作用：
 */
package com.lsm1998.jvm.config.define;

public enum Modes
{
    RUN("RUN"), INFO("INFO"), AUTH("AUTH");

    private final String mode;

    Modes(String mode)
    {
        this.mode = mode;
    }

    public String mode()
    {
        return mode;
    }
}

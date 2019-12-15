/*
 * 作者：刘时明
 * 时间：2019/12/15-15:39
 * 作用：
 */
package com.lsm1998.jvm.config;

import com.lsm1998.jvm.config.define.Config;
import com.lsm1998.jvm.config.define.Modes;
import lombok.Data;

@Data
public class JvmConfig implements Config
{
    /**
     * 基础配置(base)
     **/
    // 启动问候语
    private String hello;
    // Class文件路径
    private String classPath;
    // 运行模式
    private Modes mode;
    // jvm名称
    private String name;
    // 配置文件名称
    private String confName;

    /**
     * 虚拟机相关配置(vm)
     **/
    // 最大操作数栈深度
    private int maxStack;
}

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
    // Class对象
    private Class<?> classObj;
    // 运行模式
    private Modes mode;
    // jvm名称
    private String name;
    // 配置文件名称
    private String confName;
    // 操作系统
    private String osName;
    // CPU架构
    private String osArch;

    /**
     * 虚拟机相关配置(vm)
     **/
    // 最大操作数栈深度
    private int maxStack;
    // 最大堆内存
    private int heapMax;
    // 最小堆内存
    private int heapMin;
}

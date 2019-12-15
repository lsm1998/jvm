/*
 * 作者：刘时明
 * 时间：2019/12/15-16:01
 * 作用：元配置
 */
package com.lsm1998.jvm.config;

import java.io.File;

public class MataConfig
{
    // 操作系统
    private static final String OS_NAME;
    // CPU架构
    private static final String OS_ARCH;
    // 文件分割符
    public static final String FILE_SEPARATOR;
    // 路径分隔符
    public static final String PATH_SEPARATOR;
    // Class文件后缀
    public static final String CLASS_SUFFIX;
    // 从
    public static final String CLASS_PREFIX;

    static
    {
        OS_NAME = System.getProperty("os.name");
        OS_ARCH = System.getProperty("os.arch");
        FILE_SEPARATOR = File.separator;
        PATH_SEPARATOR = File.pathSeparator;
        CLASS_SUFFIX = ".class";
        CLASS_PREFIX = "/";
    }
}

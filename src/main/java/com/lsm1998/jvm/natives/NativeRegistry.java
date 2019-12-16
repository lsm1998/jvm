/*
 * 作者：刘时明
 * 时间：2019/12/15-23:23
 * 作用：
 */
package com.lsm1998.jvm.natives;


import com.lsm1998.jvm.natives.java.*;

import java.util.HashMap;
import java.util.Map;

public class NativeRegistry
{
    private static final Map<String, NativeMethod> registry;

    static
    {
        registry = new HashMap<>();
        new _Class();
        new _Double();
        new _Float();
        new _Object();
        new _String();
        new _System();
        new _Throwable();
    }

    public static void register(String className, String methodName, String methodDescriptor, NativeMethod method)
    {
        String key = className + "~" + methodName + "~" + methodDescriptor;
        registry.put(key, method);
    }

    public static NativeMethod findNativeMethod(String className, String methodName, String methodDescriptor)
    {
        String key = className + "~" + methodName + "~" + methodDescriptor;
        return registry.get(key);
    }
}

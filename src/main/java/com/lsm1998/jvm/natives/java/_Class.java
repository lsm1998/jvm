/*
 * 作者：刘时明
 * 时间：2019/12/15-23:24
 * 作用：
 */
package com.lsm1998.jvm.natives.java;

import com.lsm1998.jvm.natives.NativeMethod;
import com.lsm1998.jvm.natives.NativeRegistry;

public class _Class
{
    private final String jlClass = "java/lang/Class";

    public _Class()
    {
        NativeRegistry.register(jlClass, "getPrimitiveClass", "(Ljava/lang/String;)Ljava/lang/Class;", new NativeMethod(this, "getPrimitiveClass"));
        NativeRegistry.register(jlClass, "getName0", "()Ljava/lang/String;", new NativeMethod(this, "getName0"));
        NativeRegistry.register(jlClass, "desiredAssertionStatus0", "(Ljava/lang/Class;)Z", new NativeMethod(this, "desiredAssertionStatus0"));
        NativeRegistry.register(jlClass, "registerNatives", "()V", new NativeMethod(this, "registerNatives"));
    }
}

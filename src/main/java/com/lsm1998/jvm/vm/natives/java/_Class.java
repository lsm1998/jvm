/*
 * 作者：刘时明
 * 时间：2019/12/15-23:24
 * 作用：
 */
package com.lsm1998.jvm.vm.natives.java;

import org.itstack.demo.jvm._native.NativeMethod;
import org.itstack.demo.jvm._native.Registry;

public class _Class
{
    private final String jlClass = "java/lang/Class";

    public _Class()
    {
        Registry.register(jlClass, "getPrimitiveClass", "(Ljava/lang/String;)Ljava/lang/Class;", new NativeMethod(this, "getPrimitiveClass"));
        Registry.register(jlClass, "getName0", "()Ljava/lang/String;", new NativeMethod(this, "getName0"));
        Registry.register(jlClass, "desiredAssertionStatus0", "(Ljava/lang/Class;)Z", new NativeMethod(this, "desiredAssertionStatus0"));
        Registry.register(jlClass, "registerNatives", "()V", new NativeMethod(this, "registerNatives"));
    }
}

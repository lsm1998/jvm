/*
 * 作者：刘时明
 * 时间：2019/12/15-23:30
 * 作用：
 */
package com.lsm1998.jvm.vm.natives.java;

import org.itstack.demo.jvm._native.NativeMethod;
import org.itstack.demo.jvm._native.Registry;

public class _Float
{
    private final String jlFloat = "java/lang/Float";

    public _Float()
    {
        Registry.register(jlFloat, "floatToRawIntBits", "(F)I", new NativeMethod(this, "floatToRawIntBits"));
        Registry.register(jlFloat, "intBitsToFloat", "(I)F", new NativeMethod(this, "intBitsToFloat"));
        Registry.register(jlFloat, "registerNatives", "()V", new NativeMethod(this, "registerNatives"));
    }
}

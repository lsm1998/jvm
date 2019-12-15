/*
 * 作者：刘时明
 * 时间：2019/12/15-23:30
 * 作用：
 */
package com.lsm1998.jvm.vm.natives.java;

import org.itstack.demo.jvm._native.NativeMethod;
import org.itstack.demo.jvm._native.Registry;

public class _Double
{
    private final String jlDouble = "java/lang/Double";

    public _Double()
    {
        Registry.register(jlDouble, "doubleToRawLongBits", "(D)J", new NativeMethod(this, "doubleToRawLongBits"));
        Registry.register(jlDouble, "longBitsToDouble", "(J)D", new NativeMethod(this, "longBitsToDouble"));
        Registry.register(jlDouble, "registerNatives", "()V", new NativeMethod(this, "registerNatives"));
    }
}

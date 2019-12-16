/*
 * 作者：刘时明
 * 时间：2019/12/15-23:30
 * 作用：
 */
package com.lsm1998.jvm.natives.java;

import com.lsm1998.jvm.natives.NativeMethod;
import com.lsm1998.jvm.natives.NativeRegistry;

public class _Double
{
    private final String jlDouble = "java/lang/Double";

    public _Double()
    {
        NativeRegistry.register(jlDouble, "doubleToRawLongBits", "(D)J", new NativeMethod(this, "doubleToRawLongBits"));
        NativeRegistry.register(jlDouble, "longBitsToDouble", "(J)D", new NativeMethod(this, "longBitsToDouble"));
        NativeRegistry.register(jlDouble, "registerNatives", "()V", new NativeMethod(this, "registerNatives"));
    }
}

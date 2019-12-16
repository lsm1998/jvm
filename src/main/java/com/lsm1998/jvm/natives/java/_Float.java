/*
 * 作者：刘时明
 * 时间：2019/12/15-23:30
 * 作用：
 */
package com.lsm1998.jvm.natives.java;

import com.lsm1998.jvm.natives.NativeMethod;
import com.lsm1998.jvm.natives.NativeRegistry;

public class _Float
{
    private final String jlFloat = "java/lang/Float";

    public _Float()
    {
        NativeRegistry.register(jlFloat, "floatToRawIntBits", "(F)I", new NativeMethod(this, "floatToRawIntBits"));
        NativeRegistry.register(jlFloat, "intBitsToFloat", "(I)F", new NativeMethod(this, "intBitsToFloat"));
        NativeRegistry.register(jlFloat, "registerNatives", "()V", new NativeMethod(this, "registerNatives"));
    }
}

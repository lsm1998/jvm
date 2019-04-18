package com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref;

import com.lsm1998.jvm.runtimedata.publicdata.methodarea.Clazz;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ConstantPool;

/**
 * @作者：刘时明
 * @时间：2019/3/31-12:12
 * @说明：符号引用抽象类
 */
public abstract class SymRef
{
    public ConstantPool constantPool;
    public String className;
    public Clazz clazz;
}

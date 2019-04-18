package com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.constant.impl.ConstantClassInfo;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ConstantPool;
import com.lsm1998.jvm.util.ConstantUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/31-12:17
 * @说明：类符号引用
 */
public class ClassRef extends SymRef
{
    public ClassRef(ConstantPool constantPool, ConstantClassInfo classInfo, ClassFile classFile)
    {
        this.constantPool=constantPool;
        this.className= ConstantUtil.getStringByUTF8Index(classFile,classInfo.index);
    }

    @Override
    public String toString()
    {
        return "类符号引用{" +
                "类名='" + className + '\'' +
                ", 类引用地址=" + clazz.hashCode() +
                '}';
    }
}

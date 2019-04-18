package com.lsm1998.jvm.runtimedata.publicdata.methodarea;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.clazz.constant.impl.*;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref.ClassRef;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref.FieldRef;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref.InterfaceMethodRef;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref.MethodRef;

/**
 * @作者：刘时明
 * @时间：2019/3/30-19:53
 * @说明：运行时常量池
 */
public class ConstantPool
{
    public Clazz clazz;
    public Object[] constants;

    public ConstantPool(Clazz clazz, ConstantInfo[] constantInfos, ClassFile classFile)
    {
        this.clazz = clazz;
        this.constants = new Object[constantInfos.length];
        for (int i = 1; i < constantInfos.length; i++)
        {
            ConstantInfo constantInfo = constantInfos[i];
            if (constantInfo.getClass() == ConstantIntegerInfo.class)
            {
                ConstantIntegerInfo temp = (ConstantIntegerInfo) constantInfo;
                constants[i] = temp.value;
            } else if (constantInfo.getClass() == ConstantFloatInfo.class)
            {
                ConstantFloatInfo temp = (ConstantFloatInfo) constantInfo;
                constants[i] = temp.value;
            } else if (constantInfo.getClass() == ConstantLongInfo.class)
            {
                ConstantLongInfo temp = (ConstantLongInfo) constantInfo;
                constants[i++] = temp.value;
            } else if (constantInfo.getClass() == ConstantDoubleInfo.class)
            {
                ConstantDoubleInfo temp = (ConstantDoubleInfo) constantInfo;
                constants[i++] = temp.value;
            } else if (constantInfo.getClass() == ConstantUTF8Info.class)
            {
                ConstantUTF8Info temp = (ConstantUTF8Info) constantInfo;
                constants[i] = temp.value;
            } else if (constantInfo.getClass() == ConstantStringInfo.class)
            {
                ConstantStringInfo temp = (ConstantStringInfo) constantInfo;
                constants[i] = constantInfos[temp.index].toString();
            } else if (constantInfo.getClass() == ConstantClassInfo.class)
            {
                ConstantClassInfo temp = (ConstantClassInfo) constantInfo;
                ClassRef ref = new ClassRef(this, temp, classFile);
                ref.clazz=clazz;
                constants[i] = ref;
            } else if (constantInfo.getClass() == ConstantFieldRefInfo.class)
            {
                ConstantFieldRefInfo temp=(ConstantFieldRefInfo)constantInfo;
                FieldRef ref=new FieldRef(this,temp,classFile);
                ref.clazz=clazz;
                constants[i] = ref;
            } else if (constantInfo.getClass() == ConstantMethodHandleInfo.class)
            {
                constants[i] = "ConstantMethodHandleInfo!!!";
            } else if (constantInfo.getClass() == ConstantMethodRefInfo.class)
            {
                ConstantMethodRefInfo temp=(ConstantMethodRefInfo)constantInfo;
                MethodRef ref=new MethodRef(this,temp,classFile);
                ref.clazz=clazz;
                constants[i] = ref;
            } else if (constantInfo.getClass() == ConstantMethodTypeInfo.class)
            {
                constants[i] = "ConstantMethodTypeInfo!!!";
            } else if (constantInfo.getClass() == ConstantInterfaceMethodRefInfo.class)
            {
                ConstantInterfaceMethodRefInfo temp=(ConstantInterfaceMethodRefInfo)constantInfo;
                InterfaceMethodRef ref=new InterfaceMethodRef(this,temp,classFile);
                constants[i] = ref;
            } else if (constantInfo.getClass() == ConstantInvokeDynamicInfo.class)
            {
                constants[i] = "ConstantInvokeDynamicInfo!!!";
            } else if (constantInfo.getClass() == ConstantNameAndTypeInfo.class)
            {
                constants[i] = "ConstantNameAndTypeInfo!!!";
            }
        }
    }

    public Object getConstant(int index)
    {
        return constants[index];
    }
}

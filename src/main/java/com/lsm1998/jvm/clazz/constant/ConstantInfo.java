package com.lsm1998.jvm.clazz.constant;

import com.lsm1998.jvm.clazz.ClassRead;

/**
 * @作者：刘时明
 * @时间：2019/3/15-13:41
 * @作用：
 */
public interface ConstantInfo
{
    /**
     * 每个ConstantInfo由tag和元素内容组成
     * tag类型为u1，元素内容取决于tag
     * jdk虚拟机规范定义了15个tag
     */
    byte CONSTANT_Utf8 = 1;
    byte CONSTANT_Integer = 3;
    byte CONSTANT_Float = 4;
    byte CONSTANT_Long = 5;
    byte CONSTANT_Double = 6;
    byte CONSTANT_Class = 7;
    byte CONSTANT_String = 8;
    byte CONSTANT_Fieldref = 9;
    byte CONSTANT_Methodref = 10;
    byte CONSTANT_InterfaceMethodref = 11;
    byte CONSTANT_NameAndType = 12;
    byte CONSTANT_MethodHandle=15;
    byte CONSTANT_MethodType=16;
    byte CONSTANT_InvokeDynamic=18;

    /**
     * 具体的解析方法由实现类自行提供
     * @param classRead
     */
    void readInfo(ClassRead classRead);
}

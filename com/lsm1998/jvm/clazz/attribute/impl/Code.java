package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.ExceptionInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/15-19:28
 * @说明：
 */
public class Code implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度，固定为2（u4类型）
    public long attributeLength;
    // 操作数栈最大深度（u2类型）
    public int maxStack;
    // 局部变量表所需空间（u2类型）
    public int maxLocals;
    // 字节码长度（u4类型）
    public long codeLength;
    // 字节码数组
    public short[] code;
    // 异常处理表长度（u2类型）
    public int exceptionTableLength;
    // 异常处理表
    public ExceptionInfo[] exceptionInfo;
    // 属性表长度（u2类型）
    public int attributeCount;
    // 属性表
    public AttributeInfo[] attributes;


    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex= ClassReadUtil.readU2(classRead);
        attributeLength=ClassReadUtil.readU4(classRead);
        maxStack=ClassReadUtil.readU2(classRead);
        maxLocals=ClassReadUtil.readU2(classRead);
        codeLength=ClassReadUtil.readU4(classRead);
        short[] code=new short[(int)codeLength];
        for (int i = 0; i < codeLength; i++)
        {
            code[i]=ClassReadUtil.read(classRead);
        }
        this.code=code;
        exceptionTableLength=ClassReadUtil.readU2(classRead);
        exceptionInfo=new ExceptionInfo[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++)
        {
            exceptionInfo[i]=new ExceptionInfo();
            exceptionInfo[i].readInfo(classRead);
        }
        attributeCount=ClassReadUtil.readU2(classRead);
        attributes=new AttributeInfo[attributeCount];
        for (int i = 0; i < attributeCount; i++)
        {
            // 通过属性名称确定Code属性的属性表中分别引用的哪一种属性
            int attributeNameIndex=ClassReadUtil.readU2(classRead);
            String attributeName= classRead.getClassFile().getConstantInfos()[attributeNameIndex].toString();
            attributes[i]=AttributeInfo.newAttributeInfo(attributeName,classRead);
        }
    }

    @Override
    public String toString()
    {
        return "Code{" +
                "attributeNameIndex=" + attributeNameIndex +
                ", attributeLength=" + attributeLength +
                ", maxStack=" + maxStack +
                ", maxLocals=" + maxLocals +
                ", codeLength=" + codeLength +
                ", code=" + Arrays.toString(code) +
                ", ecceptionTableLength=" + exceptionTableLength +
                ", exceptionInfo=" + Arrays.toString(exceptionInfo) +
                ", attributeCount=" + attributeCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}

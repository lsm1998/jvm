package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.Classes;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/28-15:52
 * @作用：
 */
public class InnerClasses implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度，固定为2（u4类型）
    public long attributeLength;
    // Classes数组长度
    public int numberOfClasses;
    // Classes数组
    public Classes[] classes;
    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex= ClassReadUtil.readU2(classRead);
        attributeLength=ClassReadUtil.readU4(classRead);
        numberOfClasses=ClassReadUtil.readU2(classRead);
        classes=new Classes[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++)
        {
            classes[i]=new Classes();
            classes[i].readInfo(classRead);
        }
    }
}

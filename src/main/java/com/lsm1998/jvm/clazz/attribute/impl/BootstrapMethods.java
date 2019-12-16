package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.BootstrapMethod;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/28-16:02
 * @作用：
 */
public class BootstrapMethods implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度，固定为2（u4类型）
    public long attributeLength;
    // BootstrapMethod数组长度
    public int numberBootstrapMethods;
    public BootstrapMethod[] bootstrapMethods;

    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex= ClassReadUtil.readU2(classRead);
        attributeLength= ClassReadUtil.readU4(classRead);
        numberBootstrapMethods=ClassReadUtil.readU2(classRead);
        bootstrapMethods=new BootstrapMethod[numberBootstrapMethods];
        for (int i = 0; i < numberBootstrapMethods; i++)
        {
            bootstrapMethods[i]=new BootstrapMethod();
            bootstrapMethods[i].readInfo(classRead);
        }
    }
}

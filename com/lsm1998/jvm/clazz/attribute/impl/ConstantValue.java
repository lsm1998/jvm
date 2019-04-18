package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-18:27
 * @说明：
 */
public class ConstantValue implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度，固定为2（u4类型）
    public long attributeLength;
    // 字段属性在常量池的索引（u2类型）
    public int constantValueIndex;

    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex=ClassReadUtil.readU2(classRead);
        attributeLength=ClassReadUtil.readU4(classRead);
        constantValueIndex=ClassReadUtil.readU2(classRead);
    }
}

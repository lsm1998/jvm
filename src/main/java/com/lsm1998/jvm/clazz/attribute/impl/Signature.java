package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.utils.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/4/1-23:23
 * @说明：泛型签名信息
 */
public class Signature implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度（u4类型）
    public long attributeLength;
    // 常量池索引
    public int SignatureIndex;

    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex= ClassReadUtil.readU2(classRead);
        attributeLength=ClassReadUtil.readU4(classRead);
        SignatureIndex= ClassReadUtil.readU2(classRead);
    }

    @Override
    public String toString()
    {
        return "#" +SignatureIndex;
    }
}

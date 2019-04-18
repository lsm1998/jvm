package com.lsm1998.jvm.clazz;

import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.impl.ConstantValue;
import com.lsm1998.jvm.util.ByteUtil;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-16:44
 * @作用：
 */
public class Field
{
    // 字段访问标识（u2类型）
    public int accessFlags;
    // 字段名称在常量池的索引（u2类型）
    public int nameIndex;
    // 字段的类型在常量池的索引（u2类型）
    public int descriptorIndex;
    // 属性表数量（u2类型）
    public int attributesCount;
    // 属性表数组
    public AttributeInfo[] attributes;

    public void readFields(ClassRead classRead)
    {
        accessFlags = ClassReadUtil.readU2(classRead);
        nameIndex = ClassReadUtil.readU2(classRead);
        descriptorIndex = ClassReadUtil.readU2(classRead);
        attributesCount = ClassReadUtil.readU2(classRead);
        attributes=new ConstantValue[attributesCount];
        for (int i = 0; i < attributesCount; i++)
        {
            attributes[i]=new ConstantValue();
            attributes[i].readInfo(classRead);
        }
    }
}

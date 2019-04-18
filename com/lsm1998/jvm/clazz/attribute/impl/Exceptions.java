package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/4/2-14:13
 * @作用：
 */
public class Exceptions implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度（u4类型）
    public long attributeLength;

    public int exceptionsNum;

    public int[] exceptionsIndexs;

    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex= ClassReadUtil.readU2(classRead);
        attributeLength=ClassReadUtil.readU4(classRead);
        exceptionsNum=ClassReadUtil.readU2(classRead);
        exceptionsIndexs=new int[exceptionsNum];
        for (int i = 0; i < exceptionsNum; i++)
        {
            exceptionsIndexs[i]=ClassReadUtil.readU2(classRead);
        }
    }
}

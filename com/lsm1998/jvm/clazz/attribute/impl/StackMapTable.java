package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.impl.entries.Entrie;
import com.lsm1998.jvm.util.ClassReadUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:55
 * @说明：
 */
public class StackMapTable implements AttributeInfo
{
    // 属性名称在常量池的索引（u2类型）
    public int attributeNameIndex;
    // 属性长度（u4类型）
    public long attributeLength;
    public int numberOfEntries;
    public Entrie[] entries;


    @Override
    public void readInfo(ClassRead classRead)
    {
        attributeNameIndex= ClassReadUtil.readU2(classRead);
        attributeLength=ClassReadUtil.readU4(classRead);
        numberOfEntries= ClassReadUtil.readU2(classRead);
        entries=new Entrie[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++)
        {
            Entrie entrie = new Entrie();
            entries[i] = entrie.readInfo(classRead);
        }
    }

    @Override
    public String toString()
    {
        return "StackMapTable{" +
                "attributeNameIndex=" + attributeNameIndex +
                ", attributeLength=" + attributeLength +
                ", numberOfEntries=" + numberOfEntries +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }
}

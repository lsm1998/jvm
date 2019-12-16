package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ByteUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-15:22
 * @作用：
 */
public class ConstantStringInfo  implements ConstantInfo
{
    public int index;

    @Override
    public void readInfo(ClassRead classRead)
    {
        short[] s=new short[4];
        s[2] = classRead.bytes[classRead.currentIndex++];
        s[3] = classRead.bytes[classRead.currentIndex++];
        index = (int) ByteUtil.shortsToLong(s);
    }

    @Override
    public String toString()
    {
        return "#"+index;
    }
}

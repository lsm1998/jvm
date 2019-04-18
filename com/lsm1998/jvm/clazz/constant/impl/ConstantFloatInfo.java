package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ByteUtil;
import com.lsm1998.jvm.util.ClassReadUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/15-14:42
 * @作用：
 */
public class ConstantFloatInfo implements ConstantInfo
{
    public float value;

    @Override
    public void readInfo(ClassRead classRead)
    {
        short[] shorts=new short[4];
        for (int i = 0; i < shorts.length; i++)
        {
            shorts[i]=ClassReadUtil.read(classRead);
        }
        value=(float) ByteUtil.shortsToDouble(shorts);
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}

package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-14:02
 * @作用：整型字面量
 */
public class ConstantIntegerInfo implements ConstantInfo
{
    public long value;

    @Override
    public void readInfo(ClassRead classRead)
    {
        value = ClassReadUtil.readU4(classRead);
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}

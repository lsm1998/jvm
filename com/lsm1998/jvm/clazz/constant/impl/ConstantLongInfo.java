package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;

/**
 * @作者：刘时明
 * @时间：2019/3/15-15:18
 * @作用：
 */
public class ConstantLongInfo implements ConstantInfo
{
    public long value;

    @Override
    public void readInfo(ClassRead classRead)
    {
        /**
         * 暂不处理
         */
        classRead.currentIndex += 8;
    }

    @Override
    public String toString()
    {
        return String.valueOf(value);
    }
}

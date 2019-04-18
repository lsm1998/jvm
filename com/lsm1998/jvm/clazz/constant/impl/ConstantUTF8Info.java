package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-14:27
 * @作用：
 */
public class ConstantUTF8Info implements ConstantInfo
{
    public int len;
    public String value;

    @Override
    public void readInfo(ClassRead classRead)
    {
        len = ClassReadUtil.readU2(classRead);
        byte[] temp = new byte[len];
        for (int i = 0; i < len; i++)
        {
            temp[i] = (byte) classRead.bytes[classRead.currentIndex++];
        }
        value = new String(temp);
    }

    @Override
    public String toString()
    {
        return value;
    }
}

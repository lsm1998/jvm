package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/28-15:40
 * @作用：
 */
public class ConstantMethodTypeInfo  implements ConstantInfo
{
    public int descriptorIndex;

    @Override
    public void readInfo(ClassRead classRead)
    {
        descriptorIndex= ClassReadUtil.readU2(classRead);
    }

    @Override
    public String toString()
    {
        return "#"+descriptorIndex;
    }
}

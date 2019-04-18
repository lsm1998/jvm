package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-15:34
 * @作用：
 */
public class ConstantNameAndTypeInfo implements ConstantInfo
{
    public int classIndex;
    public int nameAndTypeIndex;

    @Override
    public void readInfo(ClassRead classRead)
    {
        classIndex = ClassReadUtil.readU2(classRead);
        nameAndTypeIndex = ClassReadUtil.readU2(classRead);
    }

    @Override
    public String toString()
    {
        return "#"+classIndex+",#"+nameAndTypeIndex;
    }
}

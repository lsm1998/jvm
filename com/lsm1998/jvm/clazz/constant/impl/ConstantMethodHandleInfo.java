package com.lsm1998.jvm.clazz.constant.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-15:20
 * @作用：表示方法句柄
 */
public class ConstantMethodHandleInfo implements ConstantInfo
{
    // 方法句柄类型，范围1-9
    public short referenceKind;
    // 对常量池表的有效索引
    public int referenceIndex;

    @Override
    public void readInfo(ClassRead classRead)
    {
        referenceKind = ClassReadUtil.read(classRead);
        referenceIndex= ClassReadUtil.readU2(classRead);
    }

    @Override
    public String toString()
    {
        return "#"+referenceKind+",#"+referenceIndex;
    }
}

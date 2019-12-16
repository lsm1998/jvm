package com.lsm1998.jvm.clazz.attribute.impl;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-20:30
 * @说明：
 */
public class LineNumberInfo implements AttributeInfo
{
    // 字节码行号
    public int startPc;
    // java源码行号
    public int lineNumber;

    @Override
    public void readInfo(ClassRead classRead)
    {
        startPc= ClassReadUtil.readU2(classRead);
        lineNumber= ClassReadUtil.readU2(classRead);
    }
}

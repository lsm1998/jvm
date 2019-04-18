package com.lsm1998.jvm.clazz.attribute.impl.entries;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/4/1-23:59
 * @说明：
 */
public class SameLocals1StackItem extends Entrie
{

    public SameLocals1StackItem readInfo(short frameType, ClassRead classRead)
    {
        this.frameType = frameType;
        System.out.println(ClassReadUtil.read(classRead));
        return this;
    }
}

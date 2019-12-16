package com.lsm1998.jvm.clazz.attribute.impl.entries;

import com.lsm1998.jvm.clazz.ClassRead;

/**
 * @作者：刘时明
 * @时间：2019/3/28-16:31
 * @作用：
 */
public class SameFrame extends Entrie
{
    public SameFrame readInfo(short frameType, ClassRead classRead)
    {
        this.frameType = frameType;
        return this;
    }

    @Override
    public String toString()
    {
        return "SameFrame{" +
                "frameType=" + frameType +
                '}';
    }
}

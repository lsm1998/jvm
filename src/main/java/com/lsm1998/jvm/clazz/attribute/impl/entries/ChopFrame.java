package com.lsm1998.jvm.clazz.attribute.impl.entries;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/27-22:29
 * @说明：
 */
public class ChopFrame extends Entrie
{
    public int offsetDelta;

    public ChopFrame readInfo(short frameType, ClassRead classRead)
    {
        this.frameType = frameType;
        offsetDelta = ClassReadUtil.readU2(classRead);
        return this;
    }

    @Override
    public String toString()
    {
        return "ChopFrame{" +
                "frameType=" + frameType +
                ", offsetDelta=" + offsetDelta +
                '}';
    }
}

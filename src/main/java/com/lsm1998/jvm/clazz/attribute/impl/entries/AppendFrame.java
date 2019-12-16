package com.lsm1998.jvm.clazz.attribute.impl.entries;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/27-16:56
 * @作用：
 */
public class AppendFrame extends Entrie
{
    public int offsetDelta;
    public short[] locals;

    public AppendFrame readInfo(short frameType, ClassRead classRead)
    {
        this.frameType = frameType;
        offsetDelta = ClassReadUtil.readU2(classRead);
        locals = new short[frameType - 251];
        for (int i = 0; i < locals.length; i++)
        {
            locals[i] = ClassReadUtil.read(classRead);
        }
        return this;
    }

    @Override
    public String toString()
    {
        return "AppendFrame{" +
                "frameType=" + frameType +
                ", offsetDelta=" + offsetDelta +
                ", locals=" + Arrays.toString(locals) +
                '}';
    }
}

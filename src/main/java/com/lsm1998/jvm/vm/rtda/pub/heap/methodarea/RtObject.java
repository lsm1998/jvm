/*
 * 作者：刘时明
 * 时间：2019/12/15-22:54
 * 作用：
 */
package com.lsm1998.jvm.vm.rtda.pub.heap.methodarea;

import lombok.Data;

@Data
public class RtObject
{
    private Clazz clazz;
    public Object data;
    public Object extra;

    public RtObject(Clazz clazz)
    {
        this.clazz = clazz;
        this.data = new Slots((int) clazz.getInstanceSlotCount());
    }

    public RtObject(Clazz clazz, Object data)
    {
        this.clazz = clazz;
        this.data = data;
    }

    public Slots fields()
    {
        return (Slots) this.data;
    }

    public boolean isInstanceOf(Clazz clazz)
    {
        return clazz.isAssignableFrom(this.clazz);
    }

    public RtObject getRefVar(String name, String descriptor)
    {
        ClassField field = this.clazz.getField(name, descriptor, false);
        Slots slots = (Slots) this.data;
        return slots.getRef(field.getSlotId());
    }

    public void setRefVal(String name, String descriptor, RtObject ref)
    {
        ClassField field = this.clazz.getField(name, descriptor, false);
        Slots slots = (Slots) this.data;
        slots.setRef(field.getSlotId(), ref);
    }

    public RtObject[] refs()
    {
        return (RtObject[]) this.data;
    }

    public int arrayLength()
    {
        if (this.data instanceof byte[])
        {
            return ((byte[]) this.data).length;
        }

        if (this.data instanceof short[])
        {
            return ((short[]) this.data).length;
        }

        if (this.data instanceof int[])
        {
            return ((int[]) this.data).length;
        }

        if (this.data instanceof long[])
        {
            return ((long[]) this.data).length;
        }

        if (this.data instanceof char[])
        {
            return ((char[]) this.data).length;
        }

        if (this.data instanceof float[])
        {
            return ((float[]) this.data).length;
        }

        if (this.data instanceof double[])
        {
            return ((double[]) this.data).length;
        }

        if (this.data instanceof RtObject[])
        {
            return ((RtObject[]) this.data).length;
        }
        throw new RuntimeException("Not array");
    }

    public byte[] bytes()
    {
        return (byte[]) this.data;
    }

    public short[] shorts()
    {
        return (short[]) this.data;
    }

    public int[] ints()
    {
        return (int[]) this.data;
    }

    public long[] longs()
    {
        return (long[]) this.data;
    }

    public char[] chars()
    {
        return (char[]) this.data;
    }

    public float[] floats()
    {
        return (float[]) this.data;
    }

    public double[] doubles()
    {
        return (double[]) this.data;
    }
}

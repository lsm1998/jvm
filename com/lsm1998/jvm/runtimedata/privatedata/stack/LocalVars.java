package com.lsm1998.jvm.runtimedata.privatedata.stack;

import com.lsm1998.jvm.runtimedata.privatedata.stack.Slot;
import com.lsm1998.jvm.util.ByteUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/22-19:11
 * @说明：局部变量表
 */
public class LocalVars
{
    public Slot[] slots;

    public LocalVars(Slot[] slots)
    {
        this.slots = slots;
    }

    public void setInt(int index, int val)
    {
        slots[index].num = val;
    }

    public int getInt(int index)
    {
        return slots[index].num;
    }

    public void setRef(int index, Object val)
    {
        slots[index].ref = val;
    }

    public Object getRef(int index)
    {
        return slots[index].ref;
    }

    public void setLong(int index, long val)
    {
        int[] arr = ByteUtil.longToInts(val);
        setInt(index, arr[0]);
        setInt(index + 1, arr[1]);
    }

    public long getLong(int index)
    {
        int[] arr = new int[2];
        // 此处需要注意栈结构的先进后出，需要先给低位赋值
        arr[0] = getInt(index);
        arr[1] = getInt(index + 1);
        return ByteUtil.intsToLong(arr);
    }
}

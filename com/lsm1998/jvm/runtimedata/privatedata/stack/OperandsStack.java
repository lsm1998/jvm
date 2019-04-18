package com.lsm1998.jvm.runtimedata.privatedata.stack;

import com.lsm1998.jvm.runtimedata.privatedata.stack.Slot;
import com.lsm1998.jvm.util.ByteUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/16-16:54
 * @说明：
 */
public class OperandsStack
{
    public int size;
    public Slot[] slots;

    public OperandsStack(int maxStack)
    {
        this.size = 0;
        this.slots = new Slot[maxStack];
        for (int i = 0; i < maxStack; i++)
        {
            this.slots[i] = new Slot();
        }
    }

    public void pushInt(int val)
    {
        this.slots[size++].num = val;
    }

    public int popInt()
    {
        return this.slots[--size].num;
    }

    public void pushLong(long val)
    {
        int[] arr = ByteUtil.longToInts(val);
        pushInt(arr[0]);
        pushInt(arr[1]);
    }

    public long popLong()
    {
        int[] arr = new int[2];
        // 此处需要注意栈结构的先进后出，需要先给低位赋值
        arr[1]=popInt();
        arr[0]=popInt();
        long temp=ByteUtil.intsToLong(arr);
        return temp;
    }

    public void pushRef(Object ref)
    {
        this.slots[size++].ref = ref;
    }

    public Object popRef()
    {
        Object temp = slots[--size].ref;
        slots[size].ref = null;
        return temp;
    }

    public void pushSlot(Slot slot)
    {
        this.slots[this.size++]=slot;
    }

    public Slot popSlot()
    {
        return this.slots[--this.size];
    }
}

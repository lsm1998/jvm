/*
 * 作者：刘时明
 * 时间：2019/12/15-23:00
 * 作用：
 */
package com.lsm1998.jvm.vm.rtda.pub.heap.methodarea;

import com.lsm1998.jvm.vm.rtda.pri.stack.Slot;
import lombok.Data;
import org.itstack.demo.jvm.rtda.heap.methodarea.Object;

@Data
public class Slots
{
    private Slot[] slots;

    public Slots(int len)
    {
        if (len > 0)
        {
            slots = new Slot[len];
            for (int i = 0; i < len; i++)
            {
                slots[i] = new Slot();
            }
        }
    }

    public void setInt(int idx, int val)
    {
        this.slots[idx].num = val;
    }

    public int getInt(int idx)
    {
        return this.slots[idx].num;
    }

    public void setFloat(int idx, float val)
    {
        this.slots[idx].num = (int) val;
    }

    public float getFloat(int idx)
    {
        return this.slots[idx].num;
    }

    public void setLong(int idx, long val)
    {
        this.slots[idx].num = (int) val;
        this.slots[idx + 1].num = (int) (val >> 32);
    }

    public long getLong(int idx)
    {
        int low = this.slots[idx].num;
        int high = this.slots[idx + 1].num;
        return (long) high << 32 | (long) low;
    }

    public void setDouble(int idx, double val)
    {
        this.setLong(idx, (long) val);
    }

    public Double getDouble(int idx)
    {
        return (double) this.getLong(idx);
    }

    public void setRef(int idx, RtObject ref)
    {
        this.slots[idx].ref = ref;
    }

    public RtObject getRef(int idx)
    {
        return this.slots[idx].ref;
    }
}

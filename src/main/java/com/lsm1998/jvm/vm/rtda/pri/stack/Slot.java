package com.lsm1998.jvm.vm.rtda.pri.stack;

import com.lsm1998.jvm.vm.rtda.pub.heap.methodarea.RtObject;

/**
 * @作者：刘时明
 * @时间：2019/3/16-15:14
 * @说明：
 */
public class Slot
{
    public int num;
    public RtObject ref;

    @Override
    public String toString()
    {
        if(ref==null)
        {
            return String.valueOf(num);
        }else
        {
            return ref.toString();
        }
    }
}

package com.lsm1998.jvm.rtda.pri.stack;

import com.lsm1998.jvm.rtda.pub.heap.methodarea.RtObject;
import lombok.Data;

/**
 * @作者：刘时明
 * @时间：2019/3/16-15:14
 * @说明：slot槽
 */
@Data
public class Slot
{
    private int num;
    private RtObject ref;

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

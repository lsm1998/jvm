package com.lsm1998.jvm.runtimedata.privatedata.stack;

/**
 * @作者：刘时明
 * @时间：2019/3/16-15:14
 * @说明：
 */
public class Slot
{
    public int num;
    public Object ref;

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

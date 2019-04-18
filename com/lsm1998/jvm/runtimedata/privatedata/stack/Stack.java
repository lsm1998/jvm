package com.lsm1998.jvm.runtimedata.privatedata.stack;

/**
 * @作者：刘时明
 * @时间：2019/3/16-14:41
 * @说明：
 */
public class Stack
{
    public int maxSize;
    public int size;
    public Frame top;

    public Stack(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public Frame pop()
    {
        if(this.top==null)
        {
            System.err.println("虚拟机栈为空");
        }
        Frame temp=this.top;
        this.top=top.lower;
        top.lower=null;
        this.size--;
        return temp;
    }

    public void push(Frame frame)
    {
        if (this.size > this.maxSize)
        {
            System.err.println("栈溢出");
        }
        if (this.top != null)
        {
            frame.lower = this.top;
        }
        this.top = frame;
        this.size++;
    }
}

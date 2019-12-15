package com.lsm1998.jvm.vm.rtda.pri.stack;

import lombok.Data;

/**
 * @作者：刘时明
 * @时间：2019/3/16-14:41
 * @说明：虚拟机栈
 */
@Data
public class VMStack
{
    private int maxSize;
    private int size;
    private Frame top;

    public VMStack(int maxSize)
    {
        this.maxSize = maxSize;
    }

    public Frame pop()
    {
        if (this.top == null)
        {
            System.err.println("虚拟机栈为空");
        }
        Frame temp = this.top;
        this.top = top.getLower();
        top.setLower(null);
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
            frame.setLower(this.top);
        }
        this.top = frame;
        this.size++;
    }

    public Frame top()
    {
        if (this.top == null)
        {
            throw new RuntimeException("jvm stack is empty!");
        }
        return this.top;
    }

    public Frame[] getFrames()
    {
        Frame[] frames = new Frame[this.size];
        int i = 0;
        for (Frame frame = this.top; frame != null; frame = frame.getLower())
        {
            frames[i++] = frame;
        }
        return frames;
    }

    public boolean isEmpty()
    {
        return this.top == null;
    }

    public void clear()
    {
        if (!this.isEmpty())
        {
            this.pop();
        }
    }
}

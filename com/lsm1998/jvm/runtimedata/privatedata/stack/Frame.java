package com.lsm1998.jvm.runtimedata.privatedata.stack;

import com.lsm1998.jvm.runtimedata.privatedata.Thread;

/**
 * @作者：刘时明
 * @时间：2019/3/16-15:13
 * @说明：
 */
public class Frame
{
    // 下一个栈帧的引用
    public Frame lower;
    // 局部变量表
    public LocalVars localVars;
    // 操作数栈
    public OperandsStack operandsStack;
    // 当前线程
    public Thread thread;
    public int nextPC;

    public Frame(Thread thread,int maxLocals,int maxStack)
    {
        this.thread=thread;
        Slot[] slots=new Slot[maxLocals];
        this.localVars=new LocalVars(slots);
        for (int i = 0; i < maxLocals; i++)
        {
            localVars.slots[i]=new Slot();
        }
        this.operandsStack=new OperandsStack(maxStack);
    }
}

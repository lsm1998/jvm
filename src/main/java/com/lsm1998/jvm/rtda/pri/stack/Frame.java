package com.lsm1998.jvm.rtda.pri.stack;

import com.lsm1998.jvm.rtda.pri.Thread;
import com.lsm1998.jvm.rtda.pub.heap.methodarea.ClassMethod;
import lombok.Data;

/**
 * @作者：刘时明
 * @时间：2019/3/16-15:13
 * @说明：
 */
@Data
public class Frame
{
    // 下一个栈帧的引用
    private Frame lower;
    // 局部变量表
    private LocalVars localVars;
    // 操作数栈
    private OperandsStack operandsStack;
    // 当前线程
    private Thread thread;
    private ClassMethod method;
    private int nextPC;

//    public Frame(Thread thread, int maxLocals, int maxStack)
//    {
//        this.thread = thread;
//        Slot[] slots = new Slot[maxLocals];
//        this.localVars = new LocalVars(slots);
//        for (int i = 0; i < maxLocals; i++)
//        {
//            localVars.slots[i] = new Slot();
//        }
//        this.operandsStack = new OperandsStack(maxStack);
//    }

    public Frame(Thread thread, ClassMethod method)
    {
        this.thread = thread;
        this.method = method;
        Slot[] slots = new Slot[method.getMaxLocals()];
        this.localVars = new LocalVars(slots);
        for (int i = 0; i < slots.length; i++)
        {
            localVars.slots[i] = new Slot();
        }
        this.operandsStack = new OperandsStack(method.getMaxStack());
    }

    public int nextPC()
    {
        return this.nextPC;
    }

    public void setNextPC(int nextPC)
    {
        this.nextPC = nextPC;
    }

    public void revertNextPC()
    {
        this.nextPC = this.thread.getPc();
    }
}

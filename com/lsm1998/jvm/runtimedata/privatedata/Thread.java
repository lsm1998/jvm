package com.lsm1998.jvm.runtimedata.privatedata;

import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Stack;

/**
 * @作者：刘时明
 * @时间：2019/3/16-14:40
 * @说明：
 */
public class Thread
{
    // 程序计数器
    public int pc;
    // 虚拟机栈
    public Stack stack;

    private Thread()
    {
    }

    public static Thread newThread()
    {
        Thread thread = new Thread();
        thread.pc = 0;
        thread.stack = new Stack(1024);
        return thread;
    }

    /**
     * 当前线程压入一个栈帧
     *
     * @param frame
     */
    public void pushFrame(Frame frame)
    {
        this.stack.push(frame);
    }

    /**
     * 当前线程弹出一个栈帧
     *
     * @return
     */
    public Frame popFrame()
    {
        return this.stack.pop();
    }
}

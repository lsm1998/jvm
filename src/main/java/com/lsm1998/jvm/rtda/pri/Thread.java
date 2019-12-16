package com.lsm1998.jvm.rtda.pri;

import com.lsm1998.jvm.rtda.pri.stack.Frame;
import com.lsm1998.jvm.rtda.pri.stack.VMStack;
import lombok.Data;

/**
 * @作者：刘时明
 * @时间：2019/3/16-14:40
 * @说明：线程
 */
@Data
public class Thread
{
    // 程序计数器
    private int pc;
    // 虚拟机栈
    private VMStack stack;

    public Thread(int maxStack)
    {
        this.pc = 0;
        this.stack = new VMStack(maxStack);
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

    /**
     * 获取当前栈帧
     * @return
     */
    public Frame currentFrame()
    {
        return this.stack.top();
    }
}

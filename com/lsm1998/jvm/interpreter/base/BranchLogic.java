package com.lsm1998.jvm.interpreter.base;

import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:31
 * @说明：
 */
public class BranchLogic
{
    public static void branch(Frame frame,int offset)
    {
        int pc=frame.thread.pc;
        frame.nextPC=pc+offset;
    }
}

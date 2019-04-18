package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:13
 * @说明：整型减法
 */
public class LSub extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long val1=frame.operandsStack.popLong();
        long val2=frame.operandsStack.popLong();
        long result=val1-val2;
        frame.operandsStack.pushLong(result);
    }

    @Override
    public String toString()
    {
        return "lsub";
    }
}

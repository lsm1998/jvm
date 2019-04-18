package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:35
 * @说明：无符号右移
 */
public class LUShR extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long val1=frame.operandsStack.popLong();
        long val2=frame.operandsStack.popLong();
        long result=val1>>>val2;
        frame.operandsStack.pushLong(result);
    }

    @Override
    public String toString()
    {
        return "lushr";
    }
}

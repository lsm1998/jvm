package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-21:14
 * @说明：
 */
public class FNeg extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        // float val=frame.operandsStack.popFloat();
    }

    @Override
    public String toString()
    {
        return "fneg";
    }
}

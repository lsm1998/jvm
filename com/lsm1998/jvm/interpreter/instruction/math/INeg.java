package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-21:12
 * @说明：
 */
public class INeg extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int val= frame.operandsStack.popInt();
        frame.operandsStack.pushInt(-val);
    }

    @Override
    public String toString()
    {
        return "ineg";
    }
}

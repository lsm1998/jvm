package com.lsm1998.jvm.vm.interpreter.instruction.math;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-21:12
 * @说明：
 */
public class LNeg extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long val= frame.getOperandsStack().popLong();
        frame.getOperandsStack().pushLong(-val);
    }

    @Override
    public String toString()
    {
        return "lneg";
    }
}

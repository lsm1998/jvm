package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-21:12
 * @说明：
 */
public class DNeg extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        //double val= frame.operandsStack.popDouble();
        //frame.operandsStack.pushDouble(-val);
    }

    @Override
    public String toString()
    {
        return "dneg";
    }
}

package com.lsm1998.jvm.vm.interpreter.instruction.conversations;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:16
 * @说明：
 */
public class L2I extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long val=frame.operandsStack.popLong();
        frame.operandsStack.pushInt((int)val);
    }

    @Override
    public String toString()
    {
        return "l2i";
    }
}

package com.lsm1998.jvm.vm.interpreter.instruction.stack;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:44
 * @说明：
 */
public class Pop2 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        frame.operandsStack.popSlot();
        frame.operandsStack.popSlot();
    }

    @Override
    public String toString()
    {
        return "pop2";
    }
}

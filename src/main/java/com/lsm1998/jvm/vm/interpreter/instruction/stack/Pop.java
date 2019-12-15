package com.lsm1998.jvm.vm.interpreter.instruction.stack;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:40
 * @说明：
 */
public class Pop extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        frame.getOperandsStack().popSlot();
    }

    @Override
    public String toString()
    {
        return "pop";
    }
}

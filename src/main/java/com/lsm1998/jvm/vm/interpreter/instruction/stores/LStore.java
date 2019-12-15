package com.lsm1998.jvm.vm.interpreter.instruction.stores;

import com.lsm1998.jvm.vm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:35
 * @说明：
 */
public class LStore extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
        long temp=frame.getOperandsStack().popLong();
        frame.getLocalVars().setLong(this.index,temp);
    }

    @Override
    public String toString()
    {
        return "lstore";
    }
}

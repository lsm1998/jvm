package com.lsm1998.jvm.vm.interpreter.instruction.loads;

import com.lsm1998.jvm.vm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:15
 * @说明：
 */
public class ILoad extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
        int temp=frame.getLocalVars().getInt(this.index);
        frame.getOperandsStack().pushInt(temp);
    }

    @Override
    public String toString()
    {
        return "iload";
    }
}

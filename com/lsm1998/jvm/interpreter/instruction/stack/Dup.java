package com.lsm1998.jvm.interpreter.instruction.stack;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Slot;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:45
 * @说明：复制栈顶单个变量
 */
public class Dup extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Slot slot= frame.operandsStack.popSlot();
        frame.operandsStack.pushSlot(slot);
        frame.operandsStack.pushSlot(slot);
    }

    @Override
    public String toString()
    {
        return "dup";
    }
}

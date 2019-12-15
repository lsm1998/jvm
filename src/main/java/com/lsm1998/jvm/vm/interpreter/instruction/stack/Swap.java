package com.lsm1998.jvm.vm.interpreter.instruction.stack;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.runtimedata.privatedata.stack.Frame;
import com.lsm1998.jvm.vm.runtimedata.privatedata.stack.Slot;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:07
 * @说明：交换栈顶两个元素位置
 */
public class Swap extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Slot s1= frame.operandsStack.popSlot();
        Slot s2= frame.operandsStack.popSlot();
        frame.operandsStack.pushSlot(s2);
        frame.operandsStack.pushSlot(s1);
    }

    @Override
    public String toString()
    {
        return "swap";
    }
}

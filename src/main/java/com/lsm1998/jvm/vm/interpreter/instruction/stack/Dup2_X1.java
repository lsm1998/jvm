package com.lsm1998.jvm.vm.interpreter.instruction.stack;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;
import com.lsm1998.jvm.vm.rtda.pri.stack.Slot;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:02
 * @说明：
 */
public class Dup2_X1 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Slot s1= frame.getOperandsStack().popSlot();
        Slot s2= frame.getOperandsStack().popSlot();
        Slot s3= frame.getOperandsStack().popSlot();
        frame.getOperandsStack().pushSlot(s2);
        frame.getOperandsStack().pushSlot(s1);
        frame.getOperandsStack().pushSlot(s3);
        frame.getOperandsStack().pushSlot(s2);
        frame.getOperandsStack().pushSlot(s1);
    }

    @Override
    public String toString()
    {
        return "dup2_x1";
    }
}

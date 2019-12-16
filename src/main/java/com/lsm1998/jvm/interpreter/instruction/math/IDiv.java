package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:17
 * @说明：
 */
public class IDiv extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int val1=frame.getOperandsStack().popInt();
        int val2=frame.getOperandsStack().popInt();
        int result=val1/val2;
        frame.getOperandsStack().pushInt(result);
    }

    @Override
    public String toString()
    {
        return "idiv";
    }
}

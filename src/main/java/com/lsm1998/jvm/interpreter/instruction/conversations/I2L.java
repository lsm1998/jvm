package com.lsm1998.jvm.interpreter.instruction.conversations;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:16
 * @说明：
 */
public class I2L extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int val=frame.getOperandsStack().popInt();
        frame.getOperandsStack().pushLong((long)val);
    }

    @Override
    public String toString()
    {
        return "i2l";
    }
}

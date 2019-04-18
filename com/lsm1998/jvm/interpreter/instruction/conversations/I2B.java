package com.lsm1998.jvm.interpreter.instruction.conversations;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:16
 * @说明：
 */
public class I2B extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int val=frame.operandsStack.popInt();
        frame.operandsStack.pushInt((byte)val);
    }

    @Override
    public String toString()
    {
        return "i2b";
    }
}

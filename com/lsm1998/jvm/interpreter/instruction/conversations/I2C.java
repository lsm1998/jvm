package com.lsm1998.jvm.interpreter.instruction.conversations;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-22:45
 * @说明：
 */
public class I2C extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        /**
         * 暂不考虑
         */
    }

    @Override
    public String toString()
    {
        return "i2c";
    }
}

package com.lsm1998.jvm.interpreter.instruction.constants;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:10
 * @说明：对应0x00，什么也不用做
 */
public class Nop extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {

    }

    @Override
    public String toString()
    {
        return "nop";
    }
}

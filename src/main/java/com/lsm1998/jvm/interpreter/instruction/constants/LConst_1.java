package com.lsm1998.jvm.interpreter.instruction.constants;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:57
 * @说明：
 */
public class LConst_1 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        frame.getOperandsStack().pushLong(1);
    }

    @Override
    public String toString()
    {
        return "lconst_1";
    }
}

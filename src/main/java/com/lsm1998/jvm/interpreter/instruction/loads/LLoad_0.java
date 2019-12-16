package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:15
 * @说明：
 */
public class LLoad_0 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long temp=frame.getLocalVars().getLong(0);
        frame.getOperandsStack().pushLong(temp);
    }

    @Override
    public String toString()
    {
        return "lload_0";
    }
}

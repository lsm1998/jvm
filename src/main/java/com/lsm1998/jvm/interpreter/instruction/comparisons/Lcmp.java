package com.lsm1998.jvm.interpreter.instruction.comparisons;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:22
 * @说明：
 */
public class Lcmp extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long val2=frame.getOperandsStack().popLong();
        long val1=frame.getOperandsStack().popLong();
        if(val2>val1)
        {
            frame.getOperandsStack().pushInt(1);
        }else if(val2==val1)
        {
            frame.getOperandsStack().pushInt(0);
        }else
        {
            frame.getOperandsStack().pushInt(-1);
        }
    }

    @Override
    public String toString()
    {
        return "lcmp";
    }
}

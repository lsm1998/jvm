package com.lsm1998.jvm.vm.interpreter.instruction.math;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:23
 * @说明：整型取模
 */
public class LRem extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        long val1= frame.getOperandsStack().popLong();
        long val2= frame.getOperandsStack().popLong();
        long result=val1%val2;
        frame.getOperandsStack().pushLong(result);
    }

    @Override
    public String toString()
    {
        return "lrem";
    }
}

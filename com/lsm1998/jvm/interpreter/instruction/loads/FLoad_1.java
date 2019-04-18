package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-14:29
 * @作用：
 */
public class FLoad_1 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
//        float temp=frame.localVars.getFloat(1);
//        frame.operandsStack.pushFloat(temp);
    }

    @Override
    public String toString()
    {
        return "fload_1";
    }
}

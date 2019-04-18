package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:24
 * @说明：
 */
public class FLoad extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
//        float temp=frame.localVars.getFloat(index);
//        frame.operandsStack.pushFloat(temp);
    }

    @Override
    public String toString()
    {
        return "fload";
    }
}

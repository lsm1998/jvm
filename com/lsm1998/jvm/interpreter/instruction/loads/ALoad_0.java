package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:30
 * @说明：
 */
public class ALoad_0 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Object temp=frame.localVars.getRef(0);
        frame.operandsStack.pushRef(temp);
    }

    @Override
    public String toString()
    {
        return "aload_0";
    }
}

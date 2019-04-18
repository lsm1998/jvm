package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:15
 * @说明：
 */
public class ILoad_1 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int temp=frame.localVars.getInt(1);
        frame.operandsStack.pushInt(temp);
    }

    @Override
    public String toString()
    {
        return "iload_1";
    }
}

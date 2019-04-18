package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-14:29
 * @作用：
 */
public class DLoad_3 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
//        double temp=frame.localVars.getDouble(3);
//        frame.operandsStack.pushDouble(temp);
    }

    @Override
    public String toString()
    {
        return "aload_3";
    }
}

package com.lsm1998.jvm.interpreter.instruction.stores;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:33
 * @说明：
 */
public class IStore_3 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int temp=frame.operandsStack.popInt();
        frame.localVars.setInt(3,temp);
    }

    @Override
    public String toString()
    {
        return "istore_3";
    }
}

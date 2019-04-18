package com.lsm1998.jvm.interpreter.instruction.stores;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:32
 * @说明：
 */
public class AStore_3 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Object temp=frame.operandsStack.popRef();
        frame.localVars.setRef(3,temp);
    }

    @Override
    public String toString()
    {
        return "astore_3";
    }
}

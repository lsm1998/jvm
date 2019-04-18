package com.lsm1998.jvm.interpreter.instruction.stores;

import com.lsm1998.jvm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:32
 * @说明：
 */
public class IStore extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
        int temp=frame.operandsStack.popInt();
        frame.localVars.setInt(this.index,temp);
    }

    @Override
    public String toString()
    {
        return "istore";
    }
}

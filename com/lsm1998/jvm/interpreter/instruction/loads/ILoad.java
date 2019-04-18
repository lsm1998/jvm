package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:15
 * @说明：
 */
public class ILoad extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
        int temp=frame.localVars.getInt(this.index);
        frame.operandsStack.pushInt(temp);
    }

    @Override
    public String toString()
    {
        return "iload";
    }
}

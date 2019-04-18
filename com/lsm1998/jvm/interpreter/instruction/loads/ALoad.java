package com.lsm1998.jvm.interpreter.instruction.loads;

import com.lsm1998.jvm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:28
 * @说明：
 */
public class ALoad extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
        Object temp=frame.localVars.getRef(this.index);
        frame.operandsStack.pushRef(temp);
    }

    @Override
    public String toString()
    {
        return "aload";
    }
}

package com.lsm1998.jvm.interpreter.instruction.constants;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:58
 * @说明：
 */
public class IConst_0 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        frame.operandsStack.pushInt(0);
    }

    @Override
    public String toString()
    {
        return "iconst_0";
    }
}

package com.lsm1998.jvm.interpreter.instruction.constants;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-14:02
 * @作用：
 */
public class FConst_2 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        // frame.operandsStack.pushFloat(2);
    }

    @Override
    public String toString()
    {
        return "fconst_2";
    }
}

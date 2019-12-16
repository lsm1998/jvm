package com.lsm1998.jvm.interpreter.instruction.constants;

import com.lsm1998.jvm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:15
 * @说明：
 */
public class AConst_Null implements Instruction
{
    @Override
    public void fetchOperands(ByteCodeReader reader)
    {

    }

    @Override
    public void execute(Frame frame)
    {
        frame.getOperandsStack().pushRef(null);
    }

    @Override
    public String toString()
    {
        return "aconst_null";
    }
}

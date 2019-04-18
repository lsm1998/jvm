package com.lsm1998.jvm.interpreter.instruction.constants;

import com.lsm1998.jvm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:04
 * @说明：
 */
public class BIPush implements Instruction
{
    public short val;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        val=reader.readU1();
    }

    @Override
    public void execute(Frame frame)
    {
        frame.operandsStack.pushInt(val);
    }

    @Override
    public String toString()
    {
        return "bipush";
    }
}

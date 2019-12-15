package com.lsm1998.jvm.vm.interpreter.instruction.constants;

import com.lsm1998.jvm.vm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.vm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:02
 * @说明：
 */
public class SIPush implements Instruction
{
    public int val;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        val=reader.readU2();
    }

    @Override
    public void execute(Frame frame)
    {
        frame.getOperandsStack().pushInt(val);
    }

    @Override
    public String toString()
    {
        return "sipush";
    }
}

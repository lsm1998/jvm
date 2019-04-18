package com.lsm1998.jvm.interpreter.base;

import com.lsm1998.jvm.interpreter.instruction.Instruction;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:22
 * @说明：无操作数指令抽象类
 */
public abstract class NoOperandsInstruction implements Instruction
{
    public void fetchOperands(ByteCodeReader reader)
    {

    }
}

package com.lsm1998.jvm.interpreter.base;

import com.lsm1998.jvm.interpreter.instruction.Instruction;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:28
 * @说明：跳转指令
 */
public abstract class BranchInstruction implements Instruction
{
    // 字段偏移量
    public int offSet;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        this.offSet=reader.readShort();
    }
}

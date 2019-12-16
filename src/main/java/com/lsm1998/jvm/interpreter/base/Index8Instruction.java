package com.lsm1998.jvm.interpreter.base;

import com.lsm1998.jvm.interpreter.instruction.Instruction;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:43
 * @说明：读取8位的局部变量表索引
 */
public abstract class Index8Instruction implements Instruction
{
    public int index;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        index=reader.readU1();
    }
}

package com.lsm1998.jvm.interpreter.base;

import com.lsm1998.jvm.interpreter.instruction.Instruction;

/**
 * @作者：刘时明
 * @时间：2019/3/22-20:44
 * @说明：读取8位的常量池索引
 */
public abstract class Index16Instruction  implements Instruction
{
    public int index;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        index=reader.readU2();
    }
}

package com.lsm1998.jvm.interpreter.instruction;

import com.lsm1998.jvm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/22-19:49
 * @说明：指令接口
 */
public interface Instruction
{
    /**
     * 通过BytecodeReader类提取操作数
     * @param reader
     */
    void fetchOperands(ByteCodeReader reader);

    /**
     * 在当前栈帧执行指令
     * @param frame
     */
    void execute(Frame frame);
}

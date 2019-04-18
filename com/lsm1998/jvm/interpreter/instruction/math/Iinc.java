package com.lsm1998.jvm.interpreter.instruction.math;

import com.lsm1998.jvm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;
import com.lsm1998.jvm.runtimedata.privatedata.stack.LocalVars;

/**
 * @作者：刘时明
 * @时间：2019/3/26-22:38
 * @说明：整型增加常量值
 */
public class Iinc implements Instruction
{
    public int index;
    public int consts;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        this.index=reader.readU1();
        this.consts=reader.readU1();
    }

    @Override
    public void execute(Frame frame)
    {
        LocalVars localVars=frame.localVars;
        int val=localVars.getInt(index);
        val+=consts;
        localVars.setInt(index,val);
    }

    @Override
    public String toString()
    {
        return "iinc";
    }
}

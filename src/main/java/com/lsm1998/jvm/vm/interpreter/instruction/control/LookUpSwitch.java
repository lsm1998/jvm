package com.lsm1998.jvm.vm.interpreter.instruction.control;

import com.lsm1998.jvm.vm.interpreter.base.BranchInstruction;
import com.lsm1998.jvm.vm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/27-0:11
 * @说明：
 */
public class LookUpSwitch extends BranchInstruction
{
    public long defaultOffset;
    public long npairs;
    public long[] matchOffsets;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        System.out.println("循环");
        reader.skipPadding();
        this.defaultOffset = reader.readU4();
        this.npairs = reader.readU4();
        this.matchOffsets = reader.readU4s((int) this.npairs * 2);
    }

    @Override
    public void execute(Frame frame)
    {

    }

    @Override
    public String toString()
    {
        return "lookupswitch";
    }
}

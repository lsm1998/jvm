package com.lsm1998.jvm.vm.interpreter.instruction.control;

import com.lsm1998.jvm.vm.interpreter.base.BranchInstruction;
import com.lsm1998.jvm.vm.interpreter.base.BranchLogic;
import com.lsm1998.jvm.vm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/27-0:01
 * @说明：
 */
public class TableSwitch extends BranchInstruction
{
    public long defaultOffset;
    public long low;
    public long high;
    public long[] jumpOffsets;

    @Override
    public void fetchOperands(ByteCodeReader reader)
    {
        reader.skipPadding();
        this.defaultOffset = reader.readU4();
        this.low = reader.readU4();
        this.high = reader.readU4();
        long jumpOffsetsCount=this.high-this.low+1;
        this.jumpOffsets = reader.readU4s((int)jumpOffsetsCount);
    }

    @Override
    public void execute(Frame frame)
    {
        int index=frame.getOperandsStack().popInt();
        int offset;
        if(index>=this.low&&index<=this.high)
        {
            offset = (int)this.jumpOffsets[index-(int)this.low];
        }else
        {
            offset = (int)this.defaultOffset;
        }
        BranchLogic.branch(frame, offset);
    }

    @Override
    public String toString()
    {
        return "tableswitch";
    }
}

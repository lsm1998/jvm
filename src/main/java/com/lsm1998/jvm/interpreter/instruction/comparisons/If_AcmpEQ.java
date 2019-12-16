package com.lsm1998.jvm.interpreter.instruction.comparisons;

import com.lsm1998.jvm.interpreter.base.BranchInstruction;
import com.lsm1998.jvm.interpreter.base.BranchLogic;
import com.lsm1998.jvm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:28
 * @说明：
 */
public class If_AcmpEQ extends BranchInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Object ref1=frame.getOperandsStack().popRef();
        Object ref2=frame.getOperandsStack().popRef();
        if(ref1==ref2)
        {
            BranchLogic.branch(frame,this.offSet);
        }
    }

    @Override
    public String toString()
    {
        return "if_acmpeq";
    }
}

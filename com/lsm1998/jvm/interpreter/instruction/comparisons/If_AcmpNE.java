package com.lsm1998.jvm.interpreter.instruction.comparisons;

import com.lsm1998.jvm.interpreter.base.BranchInstruction;
import com.lsm1998.jvm.interpreter.base.BranchLogic;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:36
 * @说明：
 */
public class If_AcmpNE extends BranchInstruction
{
    @Override
    public void execute(Frame frame)
    {
        Object ref1=frame.operandsStack.popRef();
        Object ref2=frame.operandsStack.popRef();
        if(ref1!=ref2)
        {
            BranchLogic.branch(frame,this.offSet);
        }
    }

    @Override
    public String toString()
    {
        return "if_acmpne";
    }
}

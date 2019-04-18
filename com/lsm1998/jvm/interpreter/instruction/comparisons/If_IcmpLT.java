package com.lsm1998.jvm.interpreter.instruction.comparisons;

import com.lsm1998.jvm.interpreter.base.BranchInstruction;
import com.lsm1998.jvm.interpreter.base.BranchLogic;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:46
 * @说明：
 */
public class If_IcmpLT extends BranchInstruction
{
    @Override
    public void execute(Frame frame)
    {
        int val1=frame.operandsStack.popInt();
        int val2=frame.operandsStack.popInt();
        if(val1<val2)
        {
            BranchLogic.branch(frame,this.offSet);
        }
    }

    @Override
    public String toString()
    {
        return "if_icmplt";
    }
}
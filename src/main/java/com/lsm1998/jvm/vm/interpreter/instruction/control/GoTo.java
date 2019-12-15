package com.lsm1998.jvm.vm.interpreter.instruction.control;

import com.lsm1998.jvm.vm.interpreter.base.BranchInstruction;
import com.lsm1998.jvm.vm.interpreter.base.BranchLogic;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/26-23:59
 * @说明：
 */
public class GoTo extends BranchInstruction
{
    @Override
    public void execute(Frame frame)
    {
        BranchLogic.branch(frame, this.offSet);
    }

    @Override
    public String toString()
    {
        return "goto";
    }
}

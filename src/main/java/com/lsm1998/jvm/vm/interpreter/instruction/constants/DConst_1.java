package com.lsm1998.jvm.vm.interpreter.instruction.constants;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-14:13
 * @作用：
 */
public class DConst_1 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        // frame.operandsStack.pushDouble(1);
    }

    @Override
    public String toString()
    {
        return "dconst_1";
    }
}

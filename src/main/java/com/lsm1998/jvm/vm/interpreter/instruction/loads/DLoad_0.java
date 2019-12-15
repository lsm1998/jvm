package com.lsm1998.jvm.vm.interpreter.instruction.loads;

import com.lsm1998.jvm.vm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-14:29
 * @作用：
 */
public class DLoad_0 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
//        double temp=frame.localVars.getDouble(0);
//        frame.operandsStack.pushDouble(temp);
    }

    @Override
    public String toString()
    {
        return "dload_0";
    }
}

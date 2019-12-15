package com.lsm1998.jvm.vm.interpreter.instruction.loads;

import com.lsm1998.jvm.vm.interpreter.base.Index8Instruction;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;
import com.lsm1998.jvm.vm.rtda.pub.heap.methodarea.RtObject;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:28
 * @说明：
 */
public class ALoad extends Index8Instruction
{
    @Override
    public void execute(Frame frame)
    {
        RtObject temp=frame.getLocalVars().getRef(this.index);
        frame.getOperandsStack().pushRef(temp);
    }

    @Override
    public String toString()
    {
        return "aload";
    }
}

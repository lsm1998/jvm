package com.lsm1998.jvm.interpreter.instruction.stores;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.rtda.pri.stack.Frame;
import com.lsm1998.jvm.rtda.pub.heap.methodarea.RtObject;

/**
 * @作者：刘时明
 * @时间：2019/3/22-21:32
 * @说明：
 */
public class AStore_2 extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        RtObject temp = frame.getOperandsStack().popRef();
        frame.getLocalVars().setRef(2, temp);
    }

    @Override
    public String toString()
    {
        return "astore_2";
    }
}

package com.lsm1998.jvm.interpreter.instruction.comparisons;

import com.lsm1998.jvm.interpreter.base.NoOperandsInstruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;

/**
 * @作者：刘时明
 * @时间：2019/3/28-23:42
 * @说明：
 */
public class DcmpL extends NoOperandsInstruction
{
    @Override
    public void execute(Frame frame)
    {
        //        double val2=frame.operandsStack.popDouble();
//        double val1=frame.operandsStack.popDouble();
//        if(val2>val1)
//        {
//            frame.operandsStack.pushInt(1);
//        }else if(val2==val1)
//        {
//            frame.operandsStack.pushInt(0);
//        }else
//        {
//            frame.operandsStack.pushInt(-1);
//        }
    }

    @Override
    public String toString()
    {
        return "dcmpl";
    }
}

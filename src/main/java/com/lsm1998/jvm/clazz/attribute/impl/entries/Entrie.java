package com.lsm1998.jvm.clazz.attribute.impl.entries;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/27-16:39
 * @作用：
 */
public class Entrie
{
    public short frameType;

    public Entrie readInfo(ClassRead classRead)
    {
        frameType = ClassReadUtil.read(classRead);
        if (frameType <= 63)
        {
            return new SameFrame().readInfo(frameType, classRead);
        } else if(frameType<=127)
        {
            return new SameLocals1StackItem().readInfo(frameType, classRead);
        }else if(frameType<=246)
        {
            // 系统预留，无意义
        }else if(frameType==247)
        {

        }else if(frameType<=250)
        {
            return new ChopFrame().readInfo(frameType,classRead);
        } else if(frameType==251)
        {

        } else if(frameType<=254)
        {
            return new AppendFrame().readInfo(frameType,classRead);
        }else if(frameType==255)
        {

        }
        return null;
    }
}

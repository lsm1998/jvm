package com.lsm1998.jvm.clazz.attribute;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/4/2-13:35
 * @作用：
 */
public class LocalVariableTableInfo
{
    public int startPc;
    public int length;
    public int nameIndex;
    public int descriptorIndex;
    public int index;

    public void readInfo(ClassRead classRead)
    {
        startPc= ClassReadUtil.readU2(classRead);
        length= ClassReadUtil.readU2(classRead);
        nameIndex= ClassReadUtil.readU2(classRead);
        descriptorIndex= ClassReadUtil.readU2(classRead);
        index= ClassReadUtil.readU2(classRead);
    }
}

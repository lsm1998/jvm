package com.lsm1998.jvm.clazz.attribute;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/28-16:10
 * @作用：
 */
public class BootstrapArgument
{
    public int index;

    public void readInfo(ClassRead classRead)
    {
        index= ClassReadUtil.readU2(classRead);
    }
}

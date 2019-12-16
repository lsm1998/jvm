package com.lsm1998.jvm.clazz.attribute;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/28-16:06
 * @作用：
 */
public class BootstrapMethod
{
    public int bootstrapMethodRef;
    public int numBootstrapArguments;
    public BootstrapArgument[] bootstrapArguments;

    public void readInfo(ClassRead classRead)
    {
        bootstrapMethodRef= ClassReadUtil.readU2(classRead);
        numBootstrapArguments=ClassReadUtil.readU2(classRead);
        bootstrapArguments=new BootstrapArgument[numBootstrapArguments];
        for (int i = 0; i < numBootstrapArguments; i++)
        {
            bootstrapArguments[i]=new BootstrapArgument();
            bootstrapArguments[i].readInfo(classRead);
        }
    }
}

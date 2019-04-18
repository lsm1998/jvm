package com.lsm1998.jvm.clazz.attribute;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/15-19:37
 * @说明：
 */
public class ExceptionInfo
{
    // 开始的程序计数器行号（u2类型）
    public int startPc;
    // 结束的程序计数器行号（u2类型）
    public int endPc;
    // 处理的程序计数器行号（u2类型）
    public int handlerPc;
    // 捕获的程序计数器行号（u2类型）
    public int catchType;

    public void readInfo(ClassRead classRead)
    {
        startPc= ClassReadUtil.readU2(classRead);
        endPc= ClassReadUtil.readU2(classRead);
        handlerPc= ClassReadUtil.readU2(classRead);
        catchType= ClassReadUtil.readU2(classRead);
    }
}

/*
 * 作者：刘时明
 * 时间：2019/12/15-23:25
 * 作用：
 */
package com.lsm1998.jvm.natives;

import com.lsm1998.jvm.rtda.pri.stack.Frame;

import java.lang.reflect.Method;

public class NativeMethod
{
    private String methodName;
    private Object obj;

    public NativeMethod(Object obj, String methodName)
    {
        this.methodName = methodName;
        this.obj = obj;
    }

    public void invoke(Frame frame)
    {
        try
        {
            Method method = obj.getClass().getMethod(methodName, frame.getClass());
            method.invoke(obj, frame);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

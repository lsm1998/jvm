package com.lsm1998.jvm.test;

/**
 * @作者：刘时明
 * @时间：2019/3/26-20:04
 * @说明：
 */
public class ClassLoaderTest extends ClassLoader
{
    public static void main(String[] args)
    {
        int a=65535/2+1;

        if(a>Short.MAX_VALUE)
        {
            System.out.println(a-(Short.MAX_VALUE+1)*2);
        }else
        {
            System.out.println(a);
        }
    }
}

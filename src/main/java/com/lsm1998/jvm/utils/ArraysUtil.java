/*
 * 作者：刘时明
 * 时间：2019/12/15-13:02
 * 作用：
 */
package com.lsm1998.jvm.utils;

public class ArraysUtil
{
    public static <E> boolean isEmpty(E[] arr)
    {
        if (arr == null || arr.length == 0)
        {
            return true;
        }
        return false;
    }
}

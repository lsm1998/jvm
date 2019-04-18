package com.lsm1998.jvm.test;

import com.lsm1998.jvm.util.ByteUtil;

/**
 * @作者：刘时明
 * @时间：2019/4/1-20:28
 * @说明：
 */
public class ByteTest
{
    public static void main(String[] args)
    {
        byte[] bytes = {0, 0, 0, 0, 0, 60, 0, 1};

        System.out.println(ByteUtil.bytesTolong(bytes));
    }
}

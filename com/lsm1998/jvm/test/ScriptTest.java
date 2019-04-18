package com.lsm1998.jvm.test;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ByteUtil;
import com.lsm1998.jvm.util.FileUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/29-12:13
 * @说明：
 */
public class ScriptTest
{
    public static void main(String[] args)
    {
        byte[] bytes= FileUtil.getBytes("java/lang/String");
        short[] shorts=ByteUtil.getUnsignedBytes(bytes);
        System.out.println(Arrays.toString(shorts));
        ClassRead.analysis(shorts);

//        byte[] bytes2= FileUtil.getBytes("E:\\Hello.class");
//        short[] shorts2=ByteUtil.getUnsignedBytes(bytes2);
//        System.out.println(Arrays.toString(shorts2));
//        ClassRead.analysis(shorts2);
    }
}

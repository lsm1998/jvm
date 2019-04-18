package com.lsm1998.jvm.util;

import com.lsm1998.jvm.clazz.ClassRead;

/**
 * @作者：刘时明
 * @时间：2019/3/15-19:24
 * @说明：
 */
public class ClassReadUtil
{
    public static short read(ClassRead classRead)
    {
        return classRead.bytes[classRead.currentIndex++];
    }

    public static int readU2(ClassRead classRead)
    {
        byte[] bytes=new byte[8];
        bytes[6]=ByteUtil.shortToByte(classRead.bytes[classRead.currentIndex++]);
        bytes[7]=ByteUtil.shortToByte(classRead.bytes[classRead.currentIndex++]);
        return (int)ByteUtil.bytesTolong(bytes);
    }

    public static long readU4(ClassRead classRead)
    {
        byte[] bytes=new byte[8];
        short s1=classRead.bytes[classRead.currentIndex++];
        short s2=classRead.bytes[classRead.currentIndex++];
        short s3=classRead.bytes[classRead.currentIndex++];
        short s4=classRead.bytes[classRead.currentIndex++];
        bytes[4]=ByteUtil.shortToByte(s1);
        bytes[5]=ByteUtil.shortToByte(s2);
        bytes[6]=ByteUtil.shortToByte(s3);
        bytes[7]=ByteUtil.shortToByte(s4);
        return ByteUtil.bytesTolong(bytes);
    }
}

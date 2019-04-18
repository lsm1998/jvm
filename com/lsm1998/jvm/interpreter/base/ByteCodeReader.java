package com.lsm1998.jvm.interpreter.base;

import com.lsm1998.jvm.util.ByteUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/22-19:50
 * @说明：
 */
public class ByteCodeReader
{
    public short[] code;
    public int pc;

    public void reSet(short[] code, int pc)
    {
        this.code = code;
        this.pc = pc;
    }

    public short readU1()
    {
        return code[this.pc++];
    }

    public byte readByte()
    {
        short temp = readU1();
        return temp>Byte.MAX_VALUE?(byte) (temp - (Byte.MAX_VALUE+1)*2):(byte) temp;
    }

    public int readU2()
    {
        return code[this.pc++]<<8|code[this.pc++];
    }

    public short readShort()
    {
        int temp = readU2();
        return temp>Short.MAX_VALUE?(short) (temp - (Short.MAX_VALUE+1)*2):(short) temp;
    }

    public long readU4()
    {
        short s1 = code[this.pc++];
        short s2 = code[this.pc++];
        short s3 = code[this.pc++];
        short s4 = code[this.pc++];
        byte[] b1 = ByteUtil.shortToBytes(s1);
        byte[] b2 = ByteUtil.shortToBytes(s2);
        byte[] b3 = ByteUtil.shortToBytes(s3);
        byte[] b4 = ByteUtil.shortToBytes(s4);
        byte[] temp = new byte[b1.length * 4];
        for (int i = 0; i < temp.length; i++)
        {
            if (i < b1.length)
            {
                temp[i] = b1[i];
            } else if (i < b2.length)
            {
                temp[i] = b2[i - b1.length];
            } else if (i < b3.length)
            {
                temp[i] = b3[i - b1.length * 2];
            } else
            {
                temp[i] = b4[i - b1.length * 3];
            }
        }
        return ByteUtil.bytesTolong(temp);
    }

    public int readInt()
    {
        long temp=readU4();
        return (int)(temp+Integer.MIN_VALUE);
    }

    public long[] readU4s(int n)
    {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = this.readU4();
        }
        return arr;
    }

    public void skipPadding()
    {
        while (this.pc % 4 != 0)
        {
            this.readU1();
        }
    }
}

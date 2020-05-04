package com.lsm1998.jvm.utils;

import java.io.*;

/**
 * @作者：刘时明
 * @时间：2019/3/15-13:08
 * @作用：
 */
public class ByteUtil
{
    /**
     * byte -》 short
     *
     * @param val
     * @return
     */
    public static short getUnsignedByte(byte val)
    {
        return (short) (val & 0xFF);
    }

    /**
     * byte[] -》 short[]
     *
     * @param val
     * @return
     */
    public static short[] getUnsignedBytes(byte[] val)
    {
        short[] temp = new short[val.length];
        for (int i = 0; i < val.length; i++)
        {
            temp[i] = getUnsignedByte(val[i]);
        }
        return temp;
    }

    /**
     * long -》 short[]
     * @param val
     * @return
     */
    public static short[] longToShorts(long val)
    {
        byte[] bytes=ByteUtil.longToBytes(val);
        return toShortArray(bytes);
    }

    /**
     * long -》 int[]
     *
     * @param val
     * @return
     */
    public static int[] longToInts(long val)
    {
        byte[] bytes=longToBytes(val);
        return toIntArray(bytes);
    }


    /**
     * short[] -》 long
     * @param shorts
     * @return
     */
    public static long shortsToLong(short[] shorts)
    {
        byte[] bytes=toByteArray(shorts);
        return ByteUtil.bytesToLong(bytes);
    }

    /**
     * int[] -》 long
     *
     * @param ints
     * @return
     */
    public static long intsToLong(int[] ints)
    {
        byte[] bytes=toByteArray(ints);
        return bytesToLong(bytes);
    }

    /**
     * short -》byte[]
     * @param val
     * @return
     */
    public static byte[] shortToBytes(short val)
    {
        byte[] bytes = new byte[2];
        bytes[0] = (byte) (val >>> 8 & 0xff);
        bytes[1] = (byte) (val >>> 0 & 0xff);
        return bytes;
    }

    /**
     * byte -》 short
     * @param bytes
     * @return
     */
    public static short bytesToShort(byte[] bytes)
    {
        return (short) (((short) bytes[0] << 8) +
                ((short) (bytes[1] & 0xff) << 0));
    }

    /**
     * int -> byte[]
     * @param val
     * @return
     */
    public static byte[] intToBytes(int val)
    {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (val >>> 24 & 0xff);
        bytes[1] = (byte) (val >>> 16 & 0xff);
        bytes[2] = (byte) (val >>> 8 & 0xff);
        bytes[3] = (byte) (val >>> 0 & 0xff);
        return bytes;
    }

    /**
     * byte[] -> int
     * @param bytes
     * @return
     */
    public static int bytesToInt(byte[] bytes)
    {
        return (((int) bytes[0] << 24) +
                ((bytes[1] & 0xff) << 16) +
                ((bytes[2] & 0xff) << 8) +
                ((bytes[3] & 0xff) << 0));
    }

    /**
     * long -> byte[]
     * @param val
     * @return
     */
    public static byte[] longToBytes(long val)
    {
        byte[] bytes = new byte[8];
        bytes[0] = (byte) (val >>> 56 & 0xff);
        bytes[1] = (byte) (val >>> 48 & 0xff);
        bytes[2] = (byte) (val >>> 40 & 0xff);
        bytes[3] = (byte) (val >>> 32 & 0xff);
        bytes[4] = (byte) (val >>> 24 & 0xff);
        bytes[5] = (byte) (val >>> 16 & 0xff);
        bytes[6] = (byte) (val >>> 8 & 0xff);
        bytes[7] = (byte) (val >>> 0 & 0xff);
        return bytes;
    }

    /**
     * byte[] -> long
     * @param bytes
     * @return
     */
    public static long bytesToLong(byte[] bytes)
    {
        return (((long) bytes[0] << 56) +
                ((long) (bytes[1] & 0xff) << 48) +
                ((long) (bytes[2] & 0xff) << 40) +
                ((long) (bytes[3] & 0xff) << 32) +
                ((long) (bytes[4] & 0xff) << 24) +
                ((long) (bytes[5] & 0xff) << 16) +
                ((long) (bytes[6] & 0xff) << 8) +
                ((long) (bytes[7] & 0xff) << 0));
    }

    /**
     * byte[] -> short[]
     * @param src
     * @return
     */
    public static short[] toShortArray(byte[] src)
    {
        int len = src.length /2;
        short[] dest = new short[len];
        for (int i = 0; i < len; i++)
        {
            byte[] bytes=new byte[2];
            for (int j = 0; j < 2; j++)
            {
                bytes[j]=src[i+j];
            }
            dest[i]=bytesToShort(bytes);
        }
        return dest;
    }

    /**
     * byte[] -> int[]
     * @param src
     * @return
     */
    public static int[] toIntArray(byte[] src)
    {
        int len=src.length/4;
        int[] dest = new int[len];
        for (int i = 0; i < len; i++)
        {
            byte[] bytes=new byte[4];
            for (int j = 0; j < 4; j++)
            {
                bytes[j]=src[i+j];
            }
            dest[i]=bytesToInt(bytes);
        }
        return dest;
    }

    /**
     * short[] -> byte[]
     * @param src
     * @return
     */
    public static byte[] toByteArray(short[] src)
    {
        int count = src.length;
        byte[] dest = new byte[count << 1];
        for (int i = 0; i < count; i++)
        {
            dest[i * 2] = (byte) (src[i] >> 8);
            dest[i * 2 + 1] = (byte) (src[i] >> 0);
        }
        return dest;
    }

    /**
     * int[] -> byte[]
     * @param src
     * @return
     */
    public static byte[] toByteArray(int[] src)
    {
        int count = src.length;
        byte[] dest = new byte[count << 2];
        for (int i = 0; i < count; i++)
        {
            dest[i * 4] = (byte) (src[i] >> 24);
            dest[i * 4 + 1] = (byte) (src[i] >> 16);
            dest[i * 4 + 2] = (byte) (src[i] >> 8);
            dest[i * 4 + 3] = (byte) (src[i] >> 0);
        }
        return dest;
    }

    /**
     * float -> bytes
     * @param val
     * @return
     */
    public static byte[] floatToBytes(float val)
    {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos))
        {
            dos.writeFloat(val);
            return baos.toByteArray();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * byte[] -> float
     * @param bytes
     * @return
     */
    public static float bytesToFloat(byte[] bytes)
    {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             DataInputStream dis = new DataInputStream(bais))
        {
            return dis.readFloat();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * double -> byte[]
     * @param val
     * @return
     */
    public static byte[] doubleToBytes(double val)
    {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos))
        {
            dos.writeDouble(val);
            return baos.toByteArray();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * byte[] -> double
     * @param bytes
     * @return
     */
    public static double bytesToDouble(byte[] bytes)
    {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
             DataInputStream dis = new DataInputStream(bais))
        {
            return dis.readDouble();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * float -> int
     * @param val
     * @return
     */
    public static int floatToInt(float val)
    {
        byte[] bytes=floatToBytes(val);
        return bytesToInt(bytes);
    }

    /**
     * int -> float
     * @param val
     * @return
     */
    public static float intTofloat(int val)
    {
        byte[] bytes=intToBytes(val);
        return bytesToFloat(bytes);
    }

    /**
     * 使用Stream流
     * @param val
     * @return
     */
    public static double longToDouble(long val)
    {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos))
        {
            dos.writeLong(val);
            return bytesToDouble(baos.toByteArray());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static float intToFloat(int val)
    {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos))
        {
            dos.writeInt(val);
            return bytesToFloat(baos.toByteArray());
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0.0f;
    }

    public static double shortsToDouble(short[] shorts)
    {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(baos))
        {
            for (int i = 0; i < shorts.length; i++)
            {
                dos.writeByte(shortToByte(shorts[i]));
            }
            byte[] bytes=baos.toByteArray();
            if(bytes.length==4)
            {
                return bytesToFloat(bytes);
            }else
            {
                return bytesToDouble(bytes);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static byte shortToByte(short val)
    {
        if(val>Byte.MAX_VALUE-Byte.MIN_VALUE)
        {
            System.err.println("过大的short类型  => "+val);
        }
        if(val>Byte.MAX_VALUE)
        {
            return (byte) (val-(Byte.MAX_VALUE+1)*2);
        }else
        {
            return (byte) val;
        }
    }
}

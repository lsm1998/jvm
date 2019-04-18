package com.lsm1998.jvm.util;

import com.lsm1998.jvm.test.ClassLoaderTest;

import java.io.*;
import java.net.URL;

/**
 * @作者：刘时明
 * @时间：2019/3/15-11:43
 * @作用：
 */
public class FileUtil
{
    // 每次最大读取2K的字节，避免过多的资源开销
    private static final int MAX_READ = 2 * 1024;

    /**
     * 根据路径读取字节数组返回
     * @param path
     * @return
     */
    public static byte[] getBytes(String path)
    {
        File file = new File(path);
        if (file.exists())
        {
            /**
             * 此处可以使用 ByteArrayInputStream
             */
            try (FileInputStream fis = new FileInputStream(file))
            {
                long len = file.length();
                byte[] bytes;
                if (len < MAX_READ)
                {
                    bytes = new byte[(int) len];
                    fis.read(bytes);
                } else
                {
                    bytes = new byte[(int) len];
                    int start = 0, size = MAX_READ, temp;
                    while ((temp = fis.read(bytes, start, size)) > 0)
                    {
                        start += temp;
                        if (start + size > len)
                        {
                            size = (int) len - start;
                        }
                    }
                }
                return bytes;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        } else
        {
            return getBytesByJar(path);
        }
        System.err.println("路径：" + path + "的文件不存在或者不可读");
        return null;
    }

    private static byte[] getBytesByJar(String name)
    {
        URL url= FileUtil.class.getResource("/"+name+".class");
        byte[] bytes=new byte[MAX_READ];
        int len;
        try(InputStream is=url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            while((len=is.read(bytes))>0)
            {
                baos.write(bytes,0,len);
            }
            return baos.toByteArray();
        }catch (Exception e)
        {
            System.err.println("找不到文件:"+name);
        }
        return null;
    }
}

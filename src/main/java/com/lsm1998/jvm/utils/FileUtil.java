package com.lsm1998.jvm.utils;

import java.io.*;
import java.net.URL;

import static com.lsm1998.jvm.config.MataConfig.CLASS_PREFIX;
import static com.lsm1998.jvm.config.MataConfig.CLASS_SUFFIX;

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
     *
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
        return null;
    }

    public static byte[] getBytesByClass(Class<?> clazz)
    {
        if(clazz!=null)
        {
            return getBytesByJar(clazz.getName().replace('.','/'));
        }
        return null;
    }

    /**
     * 根据JDK环境，获取Class文件
     *
     * @param name
     * @return
     */
    private static byte[] getBytesByJar(String name)
    {
        URL url = FileUtil.class.getResource(CLASS_PREFIX + name + CLASS_SUFFIX);
        byte[] bytes = new byte[MAX_READ];
        int len;
        try (InputStream is = url.openStream();
             ByteArrayOutputStream baos = new ByteArrayOutputStream())
        {
            while ((len = is.read(bytes)) > 0)
            {
                baos.write(bytes, 0, len);
            }
            return baos.toByteArray();
        } catch (Exception e)
        {
            throw new RuntimeException("class file not find,name=" + name);
        }
    }
}

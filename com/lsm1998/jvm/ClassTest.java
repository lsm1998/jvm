package com.lsm1998.jvm;

import com.lsm1998.jvm.runtimedata.MyClassLoader;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.Clazz;

import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/3/28-18:46
 * @说明：
 */
public class ClassTest
{
    /**
     * 解析Class文件
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        // java解析class文件命令：javap -verbose 文件名
        MyClassLoader classLoader=new MyClassLoader();
        classLoader.loadClass("D:\\test.class");
        // classLoader.loadClass("java/lang/String");
        Map<String, Clazz> map=classLoader.map;
        for (String key:map.keySet())
        {
            System.out.println(map.get(key));
        }
    }
}

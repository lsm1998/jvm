package com.lsm1998.jvm.test;

import com.lsm1998.jvm.vm.runtimedata.MyClassLoader;
import com.lsm1998.jvm.vm.runtimedata.publicdata.methodarea.Clazz;

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
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)
    {
        MyClassLoader classLoader = new MyClassLoader();
        classLoader.loadClass("C:\\Users\\Administrator\\IdeaProjects\\jvm\\target\\classes\\com\\lsm1998\\jvm\\JvmApplication.class");
        // classLoader.loadClass("java/lang/String");
        Map<String, Clazz> map = classLoader.getMap();
        for (String key : map.keySet())
        {
            System.out.println(key);
            // System.out.println(map.get(key));
        }
    }
}
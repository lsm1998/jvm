package com.lsm1998.jvm.runtimedata;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.Clazz;
import com.lsm1998.jvm.util.FileUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/1-10:07
 * @说明：
 */
public class MyClassLoader
{
    public Map<String, Clazz> map = new HashMap<>();

    public MyClassLoader()
    {

    }

    public Clazz loadClass(String path)
    {
        if (map.containsKey(path))
        {
            return map.get(path);
        }
        return defineClass(path);
    }

    private Clazz defineClass(String path)
    {
        byte[] bytes = FileUtil.getBytes(path);
        if (bytes == null)
        {
            System.err.println("找不到加载类：" + path);
        }
        ClassRead classRead = ClassRead.analysis(bytes);
        Clazz clazz = new Clazz(classRead.getClassFile());
        clazz.classLoader = this;
        // 加载父类
        resolveSuperClass(clazz);
        // 加载接口
        map.put(path, clazz);
        return clazz;
    }

    private void resolveSuperClass(Clazz clazz)
    {
        if(!clazz.className.equals("java/lang/Object"))
        {
            System.out.println("开始加载父类");
            clazz.superClass=clazz.classLoader.loadClass(clazz.superClassName);
        }else
        {
            System.out.println("Object类无父类需要加载");
        }
    }
}

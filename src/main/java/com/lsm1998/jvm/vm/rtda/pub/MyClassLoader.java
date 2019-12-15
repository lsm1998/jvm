package com.lsm1998.jvm.vm.rtda.pub;

import com.lsm1998.jvm.vm.clazz.ClassRead;
import com.lsm1998.jvm.vm.rtda.pub.heap.methodarea.Clazz;
import com.lsm1998.jvm.util.FileUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/4/1-10:07
 * @说明：
 */
@Data
public class MyClassLoader
{
    private String path;
    private Map<String, Clazz> map = new HashMap<>();

    public Clazz loadClass(String path)
    {
        this.path = path;
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
            throw new RuntimeException("找不到加载类：" + path);
        }
        ClassRead classRead = ClassRead.analysis(bytes);
        Clazz clazz = new Clazz(classRead.getClassFile());
        clazz.setClassLoader(this);
        // 加载父类
        resolveSuperClass(clazz);
        // 加载接口
        map.put(path, clazz);
        return clazz;
    }

    private void resolveSuperClass(Clazz clazz)
    {
        if (!clazz.getClassName().equals("java/lang/Object"))
        {
            clazz.setSuperClass(clazz.getClassLoader().loadClass(clazz.getSuperClassName()));
        }
    }
}

/*
 * 作者：刘时明
 * 时间：2019/12/15-12:51
 * 作用：yml文件工具类
 */
package com.lsm1998.jvm.util;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class YmlUtil
{
    public static <E> E loadYml(String path, Class<E> clazz)
    {
        Yaml yaml = new Yaml();
        return yaml.loadAs(YmlUtil.class.getResourceAsStream("/" + path), clazz);
    }

    public static Map<String, Object> loadYml(String path)
    {
        return loadYml(path, Map.class);
    }
}

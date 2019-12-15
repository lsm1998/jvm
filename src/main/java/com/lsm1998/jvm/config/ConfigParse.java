/*
 * 作者：刘时明
 * 时间：2019/12/15-16:39
 * 作用：
 */
package com.lsm1998.jvm.config;

import com.lsm1998.jvm.config.define.Config;
import com.lsm1998.jvm.config.define.Modes;

import java.util.Map;

public class ConfigParse
{
    public static void parseByConfig(Config dist,Config src)
    {

    }

    public static void parseByMap(Map<String, Object> confMap, Config config)
    {
        if (config instanceof JvmConfig)
        {
            parseBase(confMap, (JvmConfig) config);
            parseVm(confMap, (JvmConfig) config);
        } else
        {
            throw new RuntimeException("config error,need JvmConfig");
        }
    }

    private static void parseVm(Map<String, Object> confMap, JvmConfig config)
    {
        if (confMap.containsKey("vm"))
        {
            Map vmMap = (Map) confMap.get("vm");
            if (vmMap.containsKey("max-stack"))
            {
                Integer maxStack = (Integer) vmMap.get("max-stack");
                config.setMaxStack(maxStack);
            }
        }
    }

    private static void parseBase(Map<String, Object> confMap, JvmConfig config)
    {
        if (confMap.containsKey("base"))
        {
            Map vmMap = (Map) confMap.get("base");
            if (vmMap.containsKey("name") && config.getMode() == Modes.AUTH)
            {
                config.setMode(Modes.valueOf((String) vmMap.get("mode")));
            }
            if (vmMap.containsKey("name"))
            {
                config.setName((String) vmMap.get("name"));
            }
            if (vmMap.containsKey("hello"))
            {
                config.setHello((String) vmMap.get("hello"));
            }
            if (vmMap.containsKey("conf-name"))
            {
                config.setConfName((String) vmMap.get("conf-name"));
            }
            if (vmMap.containsKey("class-path") && config.getClassPath().equals("null"))
            {
                config.setClassPath((String) vmMap.get("class-path"));
            }
            if (vmMap.containsKey("log-dir"))
            {
                config.setLogDir((String) vmMap.get("log-dir"));
            }
            if (vmMap.containsKey("log-name"))
            {
                config.setLogName((String) vmMap.get("log-name"));
            }
        }
    }
}

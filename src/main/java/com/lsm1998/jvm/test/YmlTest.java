/*
 * 作者：刘时明
 * 时间：2019/12/15-15:58
 * 作用：
 */
package com.lsm1998.jvm.test;

import com.lsm1998.jvm.util.YmlUtil;

public class YmlTest
{
    public static void main(String[] args)
    {
        System.out.println(YmlUtil.loadYml("jvm.yml"));
    }
}

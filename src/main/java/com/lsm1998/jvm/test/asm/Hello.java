/*
 * 作者：刘时明
 * 时间：2019/12/15-19:00
 * 作用：
 */
package com.lsm1998.jvm.test.asm;

import lombok.Data;

@Data
public class Hello
{
    private Integer id;
    private String name;

    public static void hello()
    {
        System.out.println("hello");
    }

    public void say(String name)
    {
        System.out.println("hello" + name);
    }
}

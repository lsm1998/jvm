/*
 * 作者：刘时明
 * 时间：2019/12/15-19:23
 * 作用：使用ASM实现Class文件解析
 */
package com.lsm1998.jvm.test.asm;

import lombok.extern.slf4j.Slf4j;
import org.objectweb.asm.ClassReader;

import java.io.InputStream;

@Slf4j
public class ASMClassReader
{
    public static void accept(Class clazz) throws Exception
    {
        InputStream cl=ClassLoader.getSystemResourceAsStream(clazz.getName().replace(".","/")+".class");
        ClassReader classReader=new ClassReader(cl);
        log.info("类名={}",classReader.getClassName());
        log.info("ItemCount={}",classReader.getItemCount());
        classReader.accept(null,1);
    }

    public static void main(String[] args)  throws Exception
    {
        accept(Hello.class);
    }
}

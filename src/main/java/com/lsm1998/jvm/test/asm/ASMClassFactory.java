/*
 * 作者：刘时明
 * 时间：2019/12/15-19:11
 * 作用：使用ASM动态字节码实现Class文件工厂
 */
package com.lsm1998.jvm.test.asm;

import com.lsm1998.jvm.vm.clazz.ClassRead;
import com.lsm1998.jvm.vm.rtda.pub.heap.methodarea.Clazz;
import lombok.extern.slf4j.Slf4j;
import org.objectweb.asm.ClassWriter;

import static jdk.internal.org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static jdk.internal.org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.*;

@Slf4j
public class ASMClassFactory
{
    private volatile static ASMClassFactory factory;

    private ASMClassFactory()
    {
    }

    public synchronized static ASMClassFactory getInstance()
    {
        if (factory == null)
        {
            factory = new ASMClassFactory();
        }
        return factory;
    }

    public byte[] makeClass()
    {
        ClassWriter cw = new ClassWriter(0);
        //类版本，访问标志以及修饰符，类全名，泛型，父类，接口
        cw.visit(55, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "com/lsm1998/Hello", null, "java/lang/Object",
                new String[]{"com/lsm1998/IHello"});
        //访问标志，名字，类型，泛型，值
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "LESS", "I",
                null, new Integer(-1)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "EQUAL", "I",
                null, new Integer(0)).visitEnd();
        cw.visitField(ACC_PUBLIC + ACC_STATIC + ACC_FINAL, "GRATER", "I",
                null, new Integer(1)).visitEnd();
        //访问标志，名字，签名，泛型，throws异常
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I",
                null, null).visitEnd();
        //通知classWriter，类定义完成了
        cw.visitEnd();
        return cw.toByteArray();
    }

    public static void main(String[] args)
    {
        ASMClassFactory factory = ASMClassFactory.getInstance();
        byte[] b = factory.makeClass();
        ClassRead classRead = ClassRead.analysis(b);
        Clazz clazz = new Clazz(classRead.getClassFile());
        System.out.println(clazz);
    }
}

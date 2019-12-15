package com.lsm1998.jvm.vm.rtda.pub.heap.methodarea;

import com.lsm1998.jvm.vm.clazz.ClassFile;
import com.lsm1998.jvm.vm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.vm.rtda.pri.stack.Slot;
import com.lsm1998.jvm.vm.rtda.pub.MyClassLoader;
import com.lsm1998.jvm.util.ConstantUtil;
import lombok.Data;
import org.itstack.demo.jvm.rtda.heap.constantpool.AccessFlags;
import org.itstack.demo.jvm.rtda.heap.methodarea.Class;
import org.itstack.demo.jvm.rtda.heap.methodarea.Field;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/30-13:05
 * @说明：Class信息
 */
@Data
public class Clazz
{
    private int accessFlags;
    private String className;
    private String superClassName;
    private String[] interfaceNames;
    private ConstantInfo[] constantInfos;
    private ClassField[] fields;
    private ClassMethod[] methods;
    private MyClassLoader classLoader;
    private Clazz superClass;
    private Clazz[] interfaces;
    private long instanceSlotCount;
    private long staticSlotCount;
    private Slot staticVars;

    public Clazz(ClassFile classFile)
    {
        this.accessFlags = classFile.getAccessFlags();
        this.constantInfos = classFile.getConstantInfos();
        this.fields = ClassField.getClazzField(this, classFile);
        this.methods = ClassMethod.getClassMethod(this, classFile);
        this.className = ConstantUtil.getStringByClassInfoIndex(classFile, classFile.getThisClass());
        this.superClassName = ConstantUtil.getStringByClassInfoIndex(classFile, classFile.getSuperClass());
        this.interfaceNames = ConstantUtil.getInterfaceNames(classFile);
    }

    @Override
    public String toString()
    {
        return "类信息{" +
                "访问标识=" + accessFlags +
                ", 类名='" + className + '\'' +
                ", 父类='" + superClassName + '\'' +
                ", 接口列表=" + Arrays.toString(interfaceNames) +
                "\n" +
                ", 常量池=" + Arrays.toString(constantInfos) +
                "\n" +
                ", 字段表=" + Arrays.toString(fields) +
                "\n" +
                ", 方法表=" + Arrays.toString(methods) +
                "\n" +
                ", 父类=" + superClass.getClassName() +
                ", instanceSlotCount=" + instanceSlotCount +
                ", staticSlotCount=" + staticSlotCount +
                ", staticVars=" + staticVars +
                '}';
    }

    public boolean isInterface()
    {
        return 0 != (this.accessFlags & AccessFlags.ACC_INTERFACE);
    }

    public boolean isSubClassOf(Clazz other)
    {
        for (Clazz c = this.superClass; c != null; c = c.superClass)
        {
            if (c == other)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isSubInterfaceOf(Clazz interfaces)
    {
        for (Clazz superInterface : this.interfaces)
        {
            if (superInterface == interfaces || superInterface.isSubInterfaceOf(interfaces))
            {
                return true;
            }
        }
        return false;
    }

    public boolean isImplements(Clazz other)
    {
        for (Clazz c = this; c != null; c = c.superClass)
        {
            for (Clazz clazz : c.interfaces)
            {
                if (clazz == other || clazz.isSubInterfaceOf(other))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAssignableFrom(Clazz other)
    {
        if (this == other) return true;
        if (!other.isInterface())
        {
            return this.isSubClassOf(other);
        } else
        {
            return this.isImplements(other);
        }
    }

    public ClassField getField(String name, String descriptor, boolean isStatic)
    {
        for (Clazz c = this; c != null; c = c.superClass)
        {
            for (ClassField field : c.fields)
            {
                if (field.isStatic() == isStatic &&
                        field.getName().equals(name) &&
                        field.getDescriptor().equals(descriptor))
                {
                    return field;
                }
            }
        }
        return null;
    }
}

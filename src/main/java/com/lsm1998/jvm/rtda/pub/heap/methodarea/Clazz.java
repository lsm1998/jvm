package com.lsm1998.jvm.rtda.pub.heap.methodarea;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.attribute.impl.SourceFile;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.rtda.pri.stack.Slot;
import com.lsm1998.jvm.rtda.pub.MyClassLoader;
import com.lsm1998.jvm.util.AccessFlagsUtil;
import com.lsm1998.jvm.util.ConstantUtil;
import lombok.Data;

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
    private String sourceFile;
    private MyClassLoader classLoader;
    private Clazz superClass;
    private Clazz[] interfaces;
    private long instanceSlotCount;
    private long staticSlotCount;
    private Slot staticVars;
    private boolean initStarted;
    private Object jClass;

    public Clazz(ClassFile classFile)
    {
        this.accessFlags = classFile.getAccessFlags();
        this.constantInfos = classFile.getConstantInfos();
        this.fields = ClassField.getClazzField(this, classFile);
        this.methods = ClassMethod.getClassMethod(this, classFile);
        this.className = ConstantUtil.getStringByClassInfoIndex(classFile, classFile.getThisClass());
        this.superClassName = ConstantUtil.getStringByClassInfoIndex(classFile, classFile.getSuperClass());
        this.interfaceNames = ConstantUtil.getInterfaceNames(classFile);
        this.sourceFile = getSourceFile(classFile);
    }

    public Clazz(int accessFlags, String className, MyClassLoader classLoader, boolean initStarted, Clazz superClass, Clazz[] interfaces)
    {
        this.accessFlags = accessFlags;
        this.className = className;
        this.classLoader = classLoader;
        this.initStarted = initStarted;
        this.superClass = superClass;
        this.interfaces = interfaces;
    }

    public Clazz(int accessFlags, String className, MyClassLoader classLoader, boolean initStarted)
    {
        this.accessFlags = accessFlags;
        this.className = className;
        this.classLoader = classLoader;
        this.initStarted = initStarted;
    }

    public boolean isInterface()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_INTERFACE);
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

    public boolean isPublic()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_PUBLIC);
    }

    public boolean isFinal()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_FINAL);
    }

    public boolean isSuper()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_SUPER);
    }

    public boolean isEnum()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_ENUM);
    }

    public boolean isAbstract()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_ABSTRACT);
    }

    public String getPackageName()
    {
        int i = this.className.lastIndexOf("/");
        if (i >= 0) return this.className.substring(0, i);
        return "";
    }

    private String getSourceFile(ClassFile classFile)
    {
        SourceFile sourceFile = classFile.sourceFileAttribute();
        return null == sourceFile ? null : classFile.getStringByIndex(sourceFile.sourceFileIndex);
    }
}

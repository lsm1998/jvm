package com.lsm1998.jvm.runtimedata.publicdata.methodarea;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Slot;
import com.lsm1998.jvm.runtimedata.MyClassLoader;
import com.lsm1998.jvm.util.ConstantUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/30-13:05
 * @说明：Class信息
 */
public class Clazz
{
    public int accessFlags;
    public String className;
    public String superClassName;
    public String[] interfaceNames;
    public ConstantInfo[] constantInfos;
    public ClassField[] fields;
    public ClassMethod[] methods;
    public MyClassLoader classLoader;
    public Clazz superClass;
    public Clazz[] interfaces;
    //
    public long instanceSlotCount;
    public long staticSlotCount;
    public Slot staticVars;

    public Clazz(ClassFile classFile)
    {
        this.accessFlags = classFile.getAccessFlags();
        this.constantInfos = classFile.getConstantInfos();
        this.fields = ClassField.getClazzField(this, classFile);
        this.methods = ClassMethod.getClassMethod(this, classFile);
        this.className = ConstantUtil.getStringByClassInfoIndex(classFile,classFile.getThisClass());
        this.superClassName = ConstantUtil.getStringByClassInfoIndex(classFile,classFile.getSuperClass());
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
                "\n"+
                ", 常量池=" + Arrays.toString(constantInfos) +
                "\n"+
                ", 字段表=" + Arrays.toString(fields) +
                "\n"+
                ", 方法表=" + Arrays.toString(methods) +
                "\n"+
                ", 父类=" + superClass +
                ", interfaces=" + Arrays.toString(interfaces) +
                ", instanceSlotCount=" + instanceSlotCount +
                ", staticSlotCount=" + staticSlotCount +
                ", staticVars=" + staticVars +
                '}';
    }
}

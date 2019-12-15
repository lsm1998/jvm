package com.lsm1998.jvm.vm.runtimedata.publicdata.methodarea;

import com.lsm1998.jvm.vm.clazz.ClassFile;
import com.lsm1998.jvm.vm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.vm.runtimedata.privatedata.stack.Slot;
import com.lsm1998.jvm.vm.runtimedata.MyClassLoader;
import com.lsm1998.jvm.util.ConstantUtil;
import lombok.Data;

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
                ", instanceSlotCount=" + instanceSlotCount +
                ", staticSlotCount=" + staticSlotCount +
                ", staticVars=" + staticVars +
                '}';
    }
}

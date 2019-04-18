package com.lsm1998.jvm.runtimedata.publicdata.methodarea;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.Method;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.impl.Code;
import com.lsm1998.jvm.util.ConstantUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/30-18:11
 * @说明：
 */
public class ClassMethod
{
    private int accessFlags;
    private String name;
    private String descriptor;
    private int maxStack;
    private int maxLocals;
    private short[] code;
    private Clazz clazz;

    private ClassMethod()
    {}

    public static ClassMethod[] getClassMethod(Clazz clazz, ClassFile classFile)
    {
        Method[] methods=classFile.getMethods();
        ClassMethod[] classMethods = new ClassMethod[methods.length];
        for (int i = 0; i < classMethods.length; i++)
        {
            classMethods[i] = new ClassMethod();
            classMethods[i].clazz = clazz;
            classMethods[i].accessFlags = methods[i].accessFlags;
            classMethods[i].name= ConstantUtil.getStringByUTF8Index(classFile,methods[i].nameIndex);
            classMethods[i].descriptor = ConstantUtil.getStringByUTF8Index(classFile,methods[i].descriptorIndex);
            AttributeInfo[] attributeInfos=methods[i].attributes;
            for (int j = 0; j < attributeInfos.length; j++)
            {
                if(attributeInfos[j] instanceof Code)
                {
                    Code code=(Code)attributeInfos[j];
                    classMethods[i].maxStack=code.maxStack;
                    classMethods[i].maxLocals=code.maxLocals;
                    classMethods[i].code=code.code;
                }
            }
        }
        return classMethods;
    }

    @Override
    public String toString()
    {
        return "ClassMethod{" +
                "访问标识=" + accessFlags +
                ", 方法名='" + name + '\'' +
                ", 方法类型='" + descriptor + '\'' +
                ", 操作数栈深度=" + maxStack +
                ", 局部变量表大小=" + maxLocals +
                ", 指令=" + Arrays.toString(code) +
                ", 所属类=" + clazz.className +
                '}';
    }
}

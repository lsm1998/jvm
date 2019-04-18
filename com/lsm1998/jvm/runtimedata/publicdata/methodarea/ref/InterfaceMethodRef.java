package com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.Method;
import com.lsm1998.jvm.clazz.constant.impl.ConstantFieldRefInfo;
import com.lsm1998.jvm.clazz.constant.impl.ConstantInterfaceMethodRefInfo;
import com.lsm1998.jvm.clazz.constant.impl.ConstantNameAndTypeInfo;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ConstantPool;
import com.lsm1998.jvm.util.ConstantUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/31-14:46
 * @说明：
 */
public class InterfaceMethodRef extends SymRef
{
    public String name;
    public String descriptor;
    public Method method;

    public InterfaceMethodRef(ConstantPool constantPool, ConstantInterfaceMethodRefInfo interfaceMethodRefInfo, ClassFile classFile)
    {
        this.constantPool=constantPool;
        Object temp= classFile.getConstantInfos()[interfaceMethodRefInfo.nameAndTypeIndex];
        ConstantNameAndTypeInfo info=(ConstantNameAndTypeInfo)temp;
        this.descriptor= ConstantUtil.getStringByUTF8Index(classFile,info.nameAndTypeIndex);
        this.name=ConstantUtil.getStringByUTF8Index(classFile,info.classIndex);
        //符号引用暂不处理
        //this.field=
    }

    @Override
    public String toString()
    {
        return "接口方法符号引用{" +
                "方法名='" + name + '\'' +
                ", 类型='" + descriptor + '\'' +
                ", 引用=" + method +
                '}';
    }
}

package com.lsm1998.jvm.runtimedata.publicdata.methodarea.ref;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.Field;
import com.lsm1998.jvm.clazz.constant.impl.ConstantFieldRefInfo;
import com.lsm1998.jvm.clazz.constant.impl.ConstantNameAndTypeInfo;
import com.lsm1998.jvm.runtimedata.publicdata.methodarea.ConstantPool;
import com.lsm1998.jvm.util.ConstantUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/31-12:27
 * @说明：
 */
public class FieldRef extends SymRef
{
    public String name;
    public String descriptor;
    public Field field;

    public FieldRef(ConstantPool constantPool, ConstantFieldRefInfo fieldRefInfo, ClassFile classFile)
    {
        this.constantPool=constantPool;
        Object temp= classFile.getConstantInfos()[fieldRefInfo.nameAndTypeIndex];
        ConstantNameAndTypeInfo info=(ConstantNameAndTypeInfo)temp;
        this.descriptor=ConstantUtil.getStringByUTF8Index(classFile,info.nameAndTypeIndex);
        this.name=ConstantUtil.getStringByUTF8Index(classFile,info.classIndex);
        //符号引用暂不处理
        //this.field=
    }

    @Override
    public String toString()
    {
        return "字段符号引用{" +
                "字段名='" + name + '\'' +
                ", 类型='" + descriptor + '\'' +
                ", 引用=" + field +
                '}';
    }
}

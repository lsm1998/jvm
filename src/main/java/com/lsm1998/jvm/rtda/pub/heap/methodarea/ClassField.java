package com.lsm1998.jvm.rtda.pub.heap.methodarea;

import com.lsm1998.jvm.clazz.ClassFile;
import com.lsm1998.jvm.clazz.Field;
import com.lsm1998.jvm.util.AccessFlagsUtil;
import com.lsm1998.jvm.util.ConstantUtil;
import lombok.Data;

/**
 * @作者：刘时明
 * @时间：2019/3/30-16:50
 * @说明：字段信息
 */
@Data
public class ClassField
{
    private int accessFlags;
    private String name;
    private String descriptor;
    private Clazz clazz;
    private int slotId;

    private ClassField()
    {
    }

    public static ClassField[] getClazzField(Clazz clazz, ClassFile classFile)
    {
        Field[] fields = classFile.getFields();
        ClassField[] classFields = new ClassField[fields.length];

        for (int i = 0; i < classFields.length; i++)
        {
            classFields[i] = new ClassField();
            classFields[i].clazz = clazz;
            classFields[i].accessFlags = fields[i].accessFlags;
            classFields[i].name = ConstantUtil.getStringByUTF8Index(classFile, fields[i].nameIndex);
            classFields[i].descriptor = ConstantUtil.getStringByUTF8Index(classFile, fields[i].descriptorIndex);
        }
        return classFields;
    }

    public boolean isStatic()
    {
        return 0 != (this.accessFlags & AccessFlagsUtil.ACC_STATIC);
    }

    @Override
    public String toString()
    {
        return "ClassField{" +
                "访问标识=" + accessFlags +
                ", 字段名='" + name + '\'' +
                ", 字段类型='" + descriptor + '\'' +
                ", 所属类=" + clazz.getClassName() +
                '}';
    }
}

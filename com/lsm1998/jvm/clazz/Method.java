package com.lsm1998.jvm.clazz;

import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.impl.Code;
import com.lsm1998.jvm.clazz.attribute.impl.Deprecated;
import com.lsm1998.jvm.clazz.attribute.impl.Exceptions;
import com.lsm1998.jvm.clazz.attribute.impl.RuntimeVisibleAnnotations;
import com.lsm1998.jvm.clazz.attribute.impl.Signature;
import com.lsm1998.jvm.util.ClassReadUtil;
import com.lsm1998.jvm.util.FileUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/15-19:13
 * @说明：
 */
public class Method
{
    // 方法访问标识（u2类型）
    public int accessFlags;
    // 方法名称在常量池的索引（u2类型）
    public int nameIndex;
    // 方法的类型在常量池的索引（u2类型）
    public int descriptorIndex;
    // 属性表数量（u2类型）
    public int attributesCount;
    // 属性表数组
    public AttributeInfo[] attributes;

    public void readMethods(ClassRead classRead)
    {
        accessFlags = ClassReadUtil.readU2(classRead);
        nameIndex = ClassReadUtil.readU2(classRead);
        descriptorIndex = ClassReadUtil.readU2(classRead);
        attributesCount = ClassReadUtil.readU2(classRead);
        attributes = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++)
        {
            int index = ClassReadUtil.readU2(classRead);
            classRead.currentIndex -= 2;
            String name = classRead.getClassFile().getConstantInfos()[index].toString();
            if ("Code".equals(name))
            {
                attributes[i] = new Code();
                attributes[i].readInfo(classRead);
            } else if ("Signature".equals(name))
            {
                attributes[i] = new Signature();
                attributes[i].readInfo(classRead);
            } else if ("Exceptions".equals(name))
            {
                attributes[i] = new Exceptions();
                attributes[i].readInfo(classRead);
            } else if ("RuntimeVisibleAnnotations".equals(name))
            {
                attributes[i] = new RuntimeVisibleAnnotations();
                attributes[i].readInfo(classRead);
            } else if ("Deprecated".equals(name))
            {
                attributes[i] = new Deprecated();
                attributes[i].readInfo(classRead);
            } else
            {
                System.err.println(name + "引用属性不能识别");
            }
        }
    }

    @Override
    public String toString()
    {
        return "Methods{" +
                "访问标识=" + accessFlags +
                ", 方法名索引=#" + nameIndex +
                ", 方法类型索引=#" + descriptorIndex +
                ", 方法属性表数量=" + attributesCount +
                ", 属性表信息=" + Arrays.toString(attributes) +
                '}';
    }
}

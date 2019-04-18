package com.lsm1998.jvm.clazz.attribute;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.attribute.impl.*;
import com.lsm1998.jvm.clazz.attribute.impl.Deprecated;

/**
 * @作者：刘时明
 * @时间：2019/3/15-16:49
 * @作用：
 */
public interface AttributeInfo
{
    void readInfo(ClassRead classRead);

    static AttributeInfo newAttributeInfo(String attributeName, ClassRead classRead)
    {
        // 此处currentIndex减少2的原因是在switch中匹配的构建中会再次读取attributeNameIndex
        classRead.currentIndex-=2;
        switch (attributeName)
        {
            case "ConstantValue":
                ConstantValue constantValue=new ConstantValue();
                constantValue.readInfo(classRead);
                return constantValue;
            case "LineNumberTable":
                LineNumberTable lineNumberTable=new LineNumberTable();
                lineNumberTable.readInfo(classRead);
                return lineNumberTable;
            case "SourceFile":
                SourceFile sourceFile=new SourceFile();
                sourceFile.readInfo(classRead);
                return sourceFile;
            case "StackMapTable":
                StackMapTable stackMapTable=new StackMapTable();
                stackMapTable.readInfo(classRead);
                return stackMapTable;
            case "InnerClasses":
                InnerClasses innerClasses=new InnerClasses();
                innerClasses.readInfo(classRead);
                return innerClasses;
            case "LocalVariableTable":
                LocalVariableTable localVariableTable=new LocalVariableTable();
                localVariableTable.readInfo(classRead);
                return localVariableTable;
//            case "Deprecated":
//                Deprecated deprecated=new Deprecated();
//                deprecated.readInfo(classRead);
//                return deprecated;
            case "BootstrapMethods":
                BootstrapMethods bootstrapMethods=new BootstrapMethods();
                bootstrapMethods.readInfo(classRead);
                return bootstrapMethods;
            default:
                System.err.println("暂不支持的属性类型："+attributeName);
                return null;
        }
    }
}

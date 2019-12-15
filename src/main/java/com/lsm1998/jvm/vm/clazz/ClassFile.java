package com.lsm1998.jvm.vm.clazz;

import com.lsm1998.jvm.vm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.vm.clazz.constant.ConstantInfo;
import lombok.Data;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/15-11:43
 * @作用：Class文件数据存储类
 */
@Data
public class ClassFile
{
    // 编译版本（主版本+次版本，两个u2类型）
    private int compiledVersion;
    // 常量池大小（u2类型）
    private int constantPoolSize;
    // 常量池
    private ConstantInfo[] constantInfos;
    // 访问标志（u2类型）
    private int accessFlags;
    // 当前类名称在常量池中的索引（u2类型）
    private int thisClass;
    // 直接父类在常量池中的索引（u2类型）
    private int superClass;
    // 实现的接口数量（u2类型）
    private int interfaceCount;
    // 实现的接口其名称在常量池中的索引（u2类型的数组）
    private int[] interfaces;
    // 显式定义的字段数量，包括类字段（u2类型）
    private int fieldsCount;
    // 字段表
    private Field[] fields;
    // 方法数量
    private int methodsCount;
    // 方法表
    private Method[] methods;
    // 属性数量
    private int attributesCount;
    // 属性表
    private AttributeInfo[] attributes;

    @Override
    public String toString()
    {
        return "ClassFile{" +
                "compiledVersion=" + compiledVersion +
                ", constantPoolSize=" + constantPoolSize +
                ", constantInfos=" + Arrays.toString(constantInfos) +
                ", accessFlags=" + accessFlags +
                ", thisClass=" + thisClass +
                ", superClass=" + superClass +
                ", interfaceCount=" + interfaceCount +
                ", interfaces=" + Arrays.toString(interfaces) +
                ", fieldsCount=" + fieldsCount +
                ", fields=" + Arrays.toString(fields) +
                ", methodsCount=" + methodsCount +
                ", methods=" + Arrays.toString(methods) +
                ", attributesCount=" + attributesCount +
                ", attributes=" + Arrays.toString(attributes) +
                '}';
    }
}

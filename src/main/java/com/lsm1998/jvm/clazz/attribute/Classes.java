package com.lsm1998.jvm.clazz.attribute;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.util.ClassReadUtil;

/**
 * @作者：刘时明
 * @时间：2019/3/28-15:56
 * @作用：内部类表集合
 */
public class Classes
{
    // 内部类类型在常量池的索引
    public int innerClassInfoIndex;
    // 外部类类型在常量池的索引
    public int outerClassInfoIndex;
    // 内部类名称在常量池的索引
    public int innerNameIndex;
    // 内部类访问标识
    public int innerClassAccessFlags;

    public void readInfo(ClassRead classRead)
    {
        innerClassInfoIndex= ClassReadUtil.readU2(classRead);
        outerClassInfoIndex= ClassReadUtil.readU2(classRead);
        innerNameIndex= ClassReadUtil.readU2(classRead);
        innerClassAccessFlags= ClassReadUtil.readU2(classRead);
    }
}

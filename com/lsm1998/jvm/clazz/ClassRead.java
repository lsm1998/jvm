package com.lsm1998.jvm.clazz;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.clazz.constant.impl.*;
import com.lsm1998.jvm.util.ByteUtil;
import com.lsm1998.jvm.util.ClassReadUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @作者：刘时明
 * @时间：2019/3/15-11:40
 * @作用：
 */
public class ClassRead
{
    // class文件数据
    public short[] bytes;
    // 当前解析的位置
    public int currentIndex;
    // 编译版本对照表
    private static Map<Integer, String> versionMap;
    // 解析信息存储对象
    private ClassFile classFile;

    static
    {
        versionMap = new HashMap<>();
        versionMap.put(55, "jdk11");
        versionMap.put(54, "jdk10");
        versionMap.put(53, "jdk9");
        versionMap.put(52, "jdk8");
        versionMap.put(51, "jdk7");
        versionMap.put(50, "jdk6");
        versionMap.put(49, "jdk5");
    }

    /**
     * 解析入口
     * @param bytes
     * @return
     */
    public static ClassRead analysis(byte[] bytes)
    {
        ClassRead classRead = new ClassRead();
        classRead.currentIndex = 0;
        classRead.bytes = ByteUtil.getUnsignedBytes(bytes);
        classRead.handler();
        return classRead;
    }

    public static ClassRead analysis(short[] bytes)
    {
        ClassRead classRead = new ClassRead();
        classRead.currentIndex = 0;
        classRead.bytes = bytes;
        classRead.handler();
        return classRead;
    }

    private ClassRead()
    {
    }

    public ClassFile getClassFile()
    {
        return classFile;
    }

    private void handler()
    {
        classFile = new ClassFile();
        validateMagicNumber();
        validateCompiledVersion();
        analysisConstantPool();
        analysisAccessFlags();
        analysisThisClass();
        analysisSuperClass();
        analysisInterfaces();
        analysisFields();
        analysisMethods();
        analysisAttributes();
    }

    /**
     * 验证魔数版本
     *
     * @return
     */
    private boolean validateMagicNumber()
    {
        // ca fe ba be
        int[] temp = {0xca, 0xfe, 0xba, 0xbe};
        for (int i = 0; i < temp.length; i++, currentIndex++)
        {
            if (temp[i] != bytes[currentIndex])
            {
                System.err.println("魔数格式错误");
                return false;
            }
        }
        return true;
    }

    /**
     * 验证jdk编译版本（支持jdk5-jdk11）
     *
     * @return
     */
    private boolean validateCompiledVersion()
    {
        // 跳过主版本
        currentIndex +=2;
        int version=ClassReadUtil.readU2(this);
        if (versionMap.containsKey(version))
        {
            System.out.println("编译的jdk版本是：" + versionMap.get(version));
            classFile.setCompiledVersion(version);
            return true;
        } else
        {
            System.out.println("不支持的编译版本：" + version);
            return false;
        }
    }

    /**
     * 解析常量池
     */
    private void analysisConstantPool()
    {
        int constantPoolSize = ClassReadUtil.readU2(this);
        classFile.setConstantPoolSize(constantPoolSize);
        ConstantInfo[] constantPool = new ConstantInfo[constantPoolSize];
        // 常量池第一个位置是空的，所以从1开始迭代
        for (int i = 1; i < constantPool.length; i++)
        {
            // 读取tag标识，根据tag标识初始化常量
            byte tag = (byte) bytes[currentIndex++];
            boolean flag=true;
            switch (tag)
            {
                case ConstantInfo.CONSTANT_Utf8:
                    constantPool[i] = new ConstantUTF8Info();
                    break;
                case ConstantInfo.CONSTANT_Integer:
                    constantPool[i] = new ConstantIntegerInfo();
                    break;
                case ConstantInfo.CONSTANT_Float:
                    constantPool[i] = new ConstantFloatInfo();
                    break;
                case ConstantInfo.CONSTANT_Long:
                    constantPool[i] = new ConstantLongInfo();
                    // long与double类型占两个常量位置
                    flag=false;
                    constantPool[i].readInfo(this);
                    i++;
                    break;
                case ConstantInfo.CONSTANT_Double:
                    constantPool[i] = new ConstantDoubleInfo();
                    flag=false;
                    constantPool[i].readInfo(this);
                    i++;
                    break;
                case ConstantInfo.CONSTANT_Class:
                    constantPool[i] = new ConstantClassInfo();
                    break;
                case ConstantInfo.CONSTANT_String:
                    constantPool[i] = new ConstantStringInfo();
                    break;
                case ConstantInfo.CONSTANT_Fieldref:
                    constantPool[i] = new ConstantFieldRefInfo();
                    break;
                case ConstantInfo.CONSTANT_Methodref:
                    constantPool[i] = new ConstantMethodRefInfo();
                    break;
                case ConstantInfo.CONSTANT_InterfaceMethodref:
                    constantPool[i] = new ConstantInterfaceMethodRefInfo();
                    break;
                case ConstantInfo.CONSTANT_NameAndType:
                    constantPool[i] = new ConstantNameAndTypeInfo();
                    break;
                case ConstantInfo.CONSTANT_MethodHandle:
                    constantPool[i] = new ConstantMethodHandleInfo();
                    break;
                case ConstantInfo.CONSTANT_MethodType:
                    constantPool[i] = new ConstantMethodTypeInfo();
                    break;
                case ConstantInfo.CONSTANT_InvokeDynamic:
                    constantPool[i] = new ConstantInvokeDynamicInfo();
                    break;
                default:
                    System.err.println("不能识别的tag，tag="+tag);
                    break;
            }
            if(flag)
            {
                constantPool[i].readInfo(this);
            }
        }
        classFile.setConstantInfos(constantPool);
    }

    /**
     * 解析访问标志
     */
    private void analysisAccessFlags()
    {
        int accessFlags=ClassReadUtil.readU2(this);
        classFile.setAccessFlags(accessFlags);
        /**
         * 此处不再解析具体的访问标识名称
         * 0x21 代表 public super
         */
    }

    /**
     * 解析当前类在常量池的索引
     */
    private void analysisThisClass()
    {
        int thisClass =ClassReadUtil.readU2(this);
        classFile.setThisClass(thisClass);
    }

    /**
     * 解析直接父类在常量池的索引
     */
    private void analysisSuperClass()
    {
        short[] s=new short[4];
        s[2]=bytes[currentIndex++];
        s[3]=bytes[currentIndex++];
        int superClass=(int)ByteUtil.shortsToLong(s);
        classFile.setSuperClass(superClass);
    }

    /**
     * 解析接口相关
     */
    private void analysisInterfaces()
    {
        int interfaceCount=ClassReadUtil.readU2(this);
        classFile.setInterfaceCount(interfaceCount);
        int[] interfaces=new int[interfaceCount];
        for (int i = 0; i < interfaceCount; i++)
        {
            interfaces[i]=ClassReadUtil.readU2(this);
        }
        classFile.setInterfaces(interfaces);
    }

    /**
     * 解析字段相关
     */
    private void analysisFields()
    {
        int fieldsCount=ClassReadUtil.readU2(this);
        classFile.setFieldsCount(fieldsCount);
        Field[] fields=new Field[fieldsCount];
        for (int i = 0; i < fieldsCount; i++)
        {
            fields[i]=new Field();
            fields[i].readFields(this);
        }
        classFile.setFields(fields);
    }

    /**
     * 解析方法相关
     */
    private void analysisMethods()
    {
        int methodsCount= ClassReadUtil.readU2(this);
        classFile.setMethodsCount(methodsCount);
        Method[] methods=new Method[methodsCount];
        for (int i = 0; i < methodsCount; i++)
        {
            methods[i]=new Method();
            methods[i].readMethods(this);
        }
        classFile.setMethods(methods);
    }

    /**
     * 解析属性相关
     */
    private void analysisAttributes()
    {
        int attributesCount= ClassReadUtil.readU2(this);
        classFile.setAttributesCount(attributesCount);
        AttributeInfo[] attributes=new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++)
        {
            // 根据名称索引确定属性类型
            int attrNameIndex = ClassReadUtil.readU2(this);
            attributes[i]= AttributeInfo.newAttributeInfo(classFile.getConstantInfos()[attrNameIndex].toString(),this);
        }
        classFile.setAttributes(attributes);
    }
}

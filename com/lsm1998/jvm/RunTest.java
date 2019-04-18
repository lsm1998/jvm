package com.lsm1998.jvm;

import com.lsm1998.jvm.clazz.ClassRead;
import com.lsm1998.jvm.clazz.Method;
import com.lsm1998.jvm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.clazz.attribute.impl.Code;
import com.lsm1998.jvm.clazz.constant.ConstantInfo;
import com.lsm1998.jvm.interpreter.InstructionFactory;
import com.lsm1998.jvm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.runtimedata.privatedata.stack.Frame;
import com.lsm1998.jvm.runtimedata.privatedata.Thread;
import com.lsm1998.jvm.util.FileUtil;

import java.util.Arrays;

/**
 * @作者：刘时明
 * @时间：2019/3/28-19:35
 * @说明：
 */
public class RunTest
{
    /**
     * 解释执行一个方法
     * @param args
     */
    public static void main(String[] args)
    {
        byte[] bytes = FileUtil.getBytes("D:\\test.class");
        ClassRead classRead = ClassRead.analysis(bytes);
        Method[] methods= classRead.getClassFile().getMethods();
        ConstantInfo[] constantInfos=classRead.getClassFile().getConstantInfos();
        for (int i = 0; i < methods.length; i++)
        {
            Method method=methods[i];
            String methodName=constantInfos[method.nameIndex].toString();
            if("main".equals(methodName))
            {
                execute(method);
            }
        }
    }

    public static void execute(Method methods)
    {
        Code code=null;
        AttributeInfo[] attributeInfos=methods.attributes;
        for (int i = 0; i < attributeInfos.length; i++)
        {
            if(attributeInfos[i] instanceof Code)
            {
                code=(Code)methods.attributes[i];
            }
        }
        if(code==null)
        {
            System.err.println("找不到Code属性");
            return;
        }
        int maxLocals=code.maxLocals;
        int maxStack=code.maxStack;
        short[] codes=code.code;
        // 创建线程
        Thread thread=Thread.newThread();
        // 创建栈帧
        Frame frame=new Frame(thread,maxLocals,maxStack);
        thread.pushFrame(frame);
        System.out.println("指令条数："+codes.length);
        System.out.println("指令总览："+Arrays.toString(codes));
        while (true)
        {
            int pc=frame.nextPC;
            thread.pc=pc;
            ByteCodeReader reader=new ByteCodeReader();
            reader.reSet(codes,pc);
            short temp= reader.readU1();
            Instruction instruction= InstructionFactory.NewInstruction(temp);
            System.out.println("指令 => 操作码="+temp+" 符号="+instruction);
            if(instruction==null)
            {
                break;
            }
            instruction.fetchOperands(reader);
            frame.nextPC=reader.pc;
            // 执行指令
            instruction.execute(frame);
        }

        System.out.println(Arrays.toString( frame.localVars.slots));
    }
}

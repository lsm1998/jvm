/*
 * 作者：刘时明
 * 时间：2019/12/15-18:12
 * 作用：
 */
package com.lsm1998.jvm.config.start;

import com.lsm1998.jvm.vm.clazz.Method;
import com.lsm1998.jvm.vm.clazz.attribute.AttributeInfo;
import com.lsm1998.jvm.vm.clazz.attribute.impl.Code;
import com.lsm1998.jvm.vm.interpreter.InstructionFactory;
import com.lsm1998.jvm.vm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.vm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.vm.runtimedata.privatedata.Thread;
import com.lsm1998.jvm.vm.runtimedata.privatedata.stack.Frame;
import com.lsm1998.jvm.vm.runtimedata.publicdata.methodarea.ClassMethod;

import java.util.Arrays;

public class JvmExecute
{
    public static void executeMethod(ClassMethod method)
    {
        int maxLocals = method.getMaxLocals();
        int maxStack = method.getMaxStack();
        short[] codes = method.getCode();
        // 创建线程
        Thread thread = Thread.newThread();
        // 创建栈帧
        Frame frame = new Frame(thread, maxLocals, maxStack);
        thread.pushFrame(frame);
        System.out.println("指令条数：" + codes.length);
        System.out.println("指令总览：" + Arrays.toString(codes));
        // 字节码指令读取对象
        ByteCodeReader reader = new ByteCodeReader();
        while (true)
        {
            int pc = frame.nextPC;
            thread.pc = pc;
            reader.reSet(codes, pc);
            short temp = reader.readU1();
            Instruction instruction = InstructionFactory.NewInstruction(temp);
            System.out.println("指令 => 操作码=" + temp + " 符号=" + instruction);
            if (instruction == null)
            {
                break;
            }
            instruction.fetchOperands(reader);
            frame.nextPC = reader.pc;
            // 执行指令
            instruction.execute(frame);
        }
        System.out.println(Arrays.toString(frame.localVars.slots));
    }


}

/*
 * 作者：刘时明
 * 时间：2019/12/15-22:15
 * 作用：指令集解释器
 */
package com.lsm1998.jvm.vm;

import com.lsm1998.jvm.vm.interpreter.InstructionFactory;
import com.lsm1998.jvm.vm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.vm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.vm.natives.NativeRegistry;
import com.lsm1998.jvm.vm.rtda.pri.Thread;
import com.lsm1998.jvm.vm.rtda.pri.stack.Frame;
import com.lsm1998.jvm.vm.rtda.pub.heap.methodarea.ClassMethod;
import lombok.extern.slf4j.Slf4j;
import org.itstack.demo.jvm._native.Registry;

import java.util.Arrays;

@Slf4j
public class CodeInterpret
{
    public static void executeMethod(ClassMethod method)
    {
        short[] codes = method.getCode();
        // 创建线程
        Thread thread =new Thread();
        // 创建栈帧
        Frame frame = new Frame(thread, method);
        thread.pushFrame(frame);

        // 注册本地方法
        // NativeRegistry.initNative();
        // 字节码指令读取对象
        ByteCodeReader reader = new ByteCodeReader();
        while (true)
        {
            int pc = frame.getNextPC();
            thread.setPc(pc);
            reader.reSet(codes, pc);
            short temp = reader.readU1();
            Instruction instruction = InstructionFactory.NewInstruction(temp);
            log.info("指令 => 操作码={},符号={}", temp, instruction);
            if (instruction == null)
            {
                break;
            }
            instruction.fetchOperands(reader);
            frame.setNextPC(reader.pc);
            // 执行指令
            instruction.execute(frame);
        }
        log.info("操作数栈={}",Arrays.toString(frame.getLocalVars().slots));
    }
}

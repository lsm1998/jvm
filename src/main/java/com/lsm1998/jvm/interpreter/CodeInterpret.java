/**
 * 作者：刘时明
 * 时间：2019/12/16-8:53
 * 作用：解释器
 */
package com.lsm1998.jvm.interpreter;

import com.lsm1998.jvm.interpreter.base.ByteCodeReader;
import com.lsm1998.jvm.interpreter.instruction.Instruction;
import com.lsm1998.jvm.rtda.pri.Thread;
import com.lsm1998.jvm.rtda.pri.stack.Frame;
import com.lsm1998.jvm.rtda.pub.heap.methodarea.ClassMethod;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class CodeInterpret
{
    public static void executeMethod(ClassMethod method,int maxStack)
    {
        short[] codes = method.getCode();
        // 创建线程
        Thread thread = new Thread(maxStack);
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
        log.info("操作数栈={}", Arrays.toString(frame.getLocalVars().slots));
    }
}

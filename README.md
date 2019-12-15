# java语言实现jvm
参考JDK8标准 \
完成了简单的解释器，并新增了常量和属性等，解决一些bug

暂时只实现了简单的类加载器和简单的指令集、字节码执行引擎

<h4>使用说明</h4>
1.拉取源码，在JDK8的环境下测试通过，Class文件编译环境最好是1.8； \
2.ClassTest类作用是解析Class文件，可以指定绝对路径或者全限路径，例如字符串类为`java/lang/String`；\
3.RunTest类作用是执行一个类的主方法，需要指定该类的绝对路径，解释执行该类主方法的字节码指令，并打印Code指令；

<h4>目录说明</h4>
1.vm/clazz：目录主要定义了Class文件结构； \
2.vm/interpreter：目录主要定义了Code指令集； \
3.vm/runtimedata：目录主要定义了运行时数据区、类加载器等； \
4.test：存放测试用例，可以忽略； \
5.utils：存放工具类；\
5.config：主要是启动工作和解析配置

<h4>帮助命令</h4>
1.java解析class文件命令：javap -verbose 文件名
package cn.eric.algorithm.newfunction;

import java.util.List;

/**
 * @ClassName TenNewTest
 * @Description: TODO
 * @Author YCKJ2725
 * @Date 2019/11/6
 * @Version V1.0
 *
 * DK10中包含许多对JVM的优化：
 *
 *    将JDK多存储库合并为单存储库
 *    并行Full GC 的G1
 *    垃圾回收接口
 *    应用数据共享
 *    线程局部管控
 *    基于实验JAVA 的JIT 编译器
 *    备用内存设备上分配堆内存
 **/
public class TenNewTest {

    /**
     * 局部变量类型推断可以说是Java 10中最值得注意的特性，这是Java语言开发人员为了简化Java应用程序的编写而采取的又一步，如下图所示。
     * 局部变量类型推荐仅限于如下使用场景：
     *
     * 局部变量初始化
     *    for循环内部索引变量
     *    传统的for循环声明变量
     *    Java官方表示，它不能用于以下几个地方：
     *
     * 方法参数
     *    构造函数参数
     *    方法返回类型
     *    字 段
     *    捕获表达式（或任何其他类型的变量声明）
    **/
    public static void main(String[] args) {

        var sds = List.of("sds", "ccd", "sds");
        System.out.println(sds.toString());
    }
}

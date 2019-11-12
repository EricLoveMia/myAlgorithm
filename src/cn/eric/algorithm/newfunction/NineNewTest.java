package cn.eric.algorithm.newfunction;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NineNewTest
 * @Description: TODO
 * @Author YCKJ2725
 * @Date 2019/11/6
 * @Version V1.0
 **/
public class NineNewTest {

    /**不可变集合工厂方法
     * Java 9增加了List.of()、Set.of()、Map.of()和Map.ofEntries()等工厂方法来创建不可变集合。
     * List strs = List.of("Hello", "World");
     * List strs List.of(1, 2, 3);
     * Set strs = Set.of("Hello", "World");
     * Set ints = Set.of(1, 2, 3);
     * Map maps = Map.of("Hello", 1, "World", 2);
    **/
    public static void testFinalCollections(){
        List<String> aaa = List.of("aaa", "bbb");
        Map<String, Integer> hello = Map.of("Hello", 1, "World", 2);
        System.out.println(aaa.toString());
        System.out.println(hello);
    }

    /**
     * I/O 流新特性
     * java.io.InputStream 中增加了新的方法来读取和复制 InputStream 中包含的数据。
     *    readAllBytes：读取 InputStream 中的所有剩余字节。
     *    readNBytes： 从 InputStream 中读取指定数量的字节到数组中。
     *    transferTo：读取 InputStream 中的全部字节并写入到指定的 OutputStream 中
    **/
    public void testIO(){
        try(InputStream resourceAsStream = this.getClass().getResourceAsStream("1.txt");
        OutputStream outputStream = new FileOutputStream(new File("d:\\2.txt"))) {
            // InputStream stream = new BufferedInputStream(resourceAsStream);
            byte[] bytes;
            // bytes  = resourceAsStream.readAllBytes();
            // bytes = resourceAsStream.readNBytes(10);
            resourceAsStream.transferTo(outputStream);
            // System.out.println(new String(bytes));
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws IOException {
        // NineNewTest.testFinalCollections();
        NineNewTest test = new NineNewTest();
        test.testIO();
    }
}

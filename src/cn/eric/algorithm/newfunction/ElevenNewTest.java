package cn.eric.algorithm.newfunction;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @ClassName ElevenNewTest
 * @Description: TODO
 * @Author YCKJ2725
 * @Date 2019/11/6
 * @Version V1.0
 **/
public class ElevenNewTest {

    /**
     * TTPClient转正
     * JDK9中便引入httpclient模块，但它在jdk.incubator.httpclient包下，在java11被标记为正式，改为java.net.http模块。
     **/
    public static void httpTest() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2) // .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofMillis(5000)) // 连接超时时间，单位为毫秒
                .followRedirects(HttpClient.Redirect.NEVER)  // 连接完成之后的转发策略
                //.executor(Executors.newFixedThreadPool(5)) // 线程池
                //认证，默认情况下 Authenticator.getDefault() 是 null 值，会报错
                //.authenticator(Authenticator.getDefault())
                //代理地址
                //.proxy(ProxySelector.of(new InetSocketAddress("http://www.baidu.com", 8080)))
                //缓存，默认情况下 CookieHandler.getDefault() 是 null 值，会报错
                //.cookieHandler(CookieHandler.getDefault())
                .build();
        HttpRequest request = HttpRequest.newBuilder()//存入消息头
                //消息头是保存在一张 TreeMap 里的
                .header("Content-Type", "application/json")
                //http 协议版本
                .version(HttpClient.Version.HTTP_2)
                //url 地址
                //.uri(URI.create("http://openjdk.java.net/"))
                .uri(URI.create("https://www.baidu.com/"))
                //超时时间
                .timeout(Duration.ofMillis(5009))
                //发起一个 post 消息，需要存入一个消息体
                //.POST(HttpRequest.BodyPublishers.ofString("hello"))
                //发起一个 get 消息，get 不需要消息体
                .GET()
                //method(...) 方法是 POST(...) 和 GET(...) 方法的底层，效果一样
                //.method("POST",HttpRequest.BodyPublishers.ofString("hello"))
                //创建完成
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

//         try {
//             //返回的是 future，然后通过 future 来获取结果
//             CompletableFuture<String> future =
//                     client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                             .thenApply(HttpResponse::body);
//             //阻塞线程，从 future 中获取结果
//             String body = future.get();
//         } catch (ExecutionException e) {
//             e.printStackTrace();
//         }


    }

    /** *
     * 更灵活的String
     * 去除空白
     * JAVA11(JDK11)中的strip()方法，适用于字符首尾空白是Unicode空白字符的情况
     * trim()方法移除字符串两侧的空白字符(空格、tab键、换行符)
     * 支持Unicode的空白字符的判断应该使用isWhitespace(int)。
     * 此外，开发人员无法专门删除缩进空白或专门删除尾随空白。
     * 简单得说就是，trim()方法无法删除掉Unicode空白字符，但用Character.isWhitespace©方法可以判断出来。
     *
     * String text = "  \u2000a  b  ";
     * Assert.assertEquals("a  b",text.strip());
     * Assert.assertEquals("\u2000a  b",text.trim());
     * Assert.assertEquals("a  b  ",text.stripLeading());
     * Assert.assertEquals("  \u2000a  b",text.stripTrailing());
     *
     *
     * lines()
     * 字符串实例方法，使用专门的 Spliterator 来懒惰地提供源字符串中的行
     * "test\nhoge\n".lines().map(String::toUpperCase).toArray()
     * 输出： Object[2] { "TEST", "HOGE" }
     *
     * repeat(int)
     * 按照参数 int 提供的次数来重复字符串的运行次数
     *
     * isBlank()
     * 验证当前字符串是否为空，或者是否只包括空白字符（空白字符由 Character.isWhiteSpace(int) 验证）
    **/
    public static void stringNewTest(){
        String text = "  \u2000a  b  ";
        System.out.println("a  b".equals(text.strip()));
        System.out.println("\u2000a  b".equals(text.trim()));
        System.out.println("a  b  ".equals(text.stripLeading()));
        System.out.println("  \u2000a  b".equals(text.stripTrailing()));

        var objects = "test\nhoge\n".lines().map(String::toUpperCase).toArray();
        System.out.println(objects[0].toString() + " : " + objects[1].toString());

        System.out.println("test\n".repeat(3));

        System.out.println("".isBlank());
        System.out.println("\\u0020".isBlank());
        System.out.println("\\u3000".isBlank());

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        // ElevenNewTest.httpTest();

        ElevenNewTest.stringNewTest();
    }

}

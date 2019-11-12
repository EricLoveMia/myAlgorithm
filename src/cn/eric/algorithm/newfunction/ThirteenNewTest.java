package cn.eric.algorithm.newfunction;

/**
 * @ClassName ThirteenNewTest
 * @Description: TODO
 * @Author YCKJ2725
 * @Date 2019/11/8
 * @Version V1.0
 **/
public class ThirteenNewTest {

    /***
     * swich 的优化
    **/
    static void newSwichTest(int k) {

        System.out.println(
                switch (k) {
                    case  1 -> "one";
                    case  2 -> "two";
                    default -> "many";
                }
        );
    }

    /***
     *  文本块
     *
     * """
     * line 1
     * line 2
     * line 3
     * """
     *  等于字符串文字：
     *
     * "line 1\nline 2\nline 3\n"
     *
     * */
    static void newStringTest() {
        String html = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";
        /** JDK13优化的 */

        String html2 = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
              """;
        System.out.println(html);
        System.out.println(html2);
    }

    public static void main(String[] args) {
        ThirteenNewTest.newSwichTest(1);
        ThirteenNewTest.newStringTest();
    }
}

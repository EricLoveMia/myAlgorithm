package cn.eric.algorithm.newfunction;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;

/**
 * @ClassName TwelveNewTest
 * @Description: TODO
 * @Author YCKJ2725
 * @Date 2019/11/6
 * @Version V1.0
 **/
public class TwelveNewTest {

    private static final int MONDAY = 1;
    private static final int TUESDAY = 2;
    private static final int WEDNESDAY = 3;
    private static final int THURSDAY = 4;
    private static final int FRIDAY = 5;
    private static final int SATURDAY = 6;
    private static final int SUNDAY = 7;
    /**
     * switch语句
    **/
    public static void switchTest() {
        var day = 2;
        switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> System.out.println(6);
            case TUESDAY -> System.out.println(7);
            case THURSDAY, SATURDAY -> System.out.println(8);
            case WEDNESDAY -> System.out.println(9);
            default -> System.out.println(0);
        }

        /** 13的语法 */
        System.out.println(switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> -1;
        });
    }

    /**
     * 数字转字符串NumberFormat
    **/
    public static void numberFormatTest(){
        var cnf = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
        System.out.println(cnf.format(1_0000));
        System.out.println(cnf.format(1_9200));
        System.out.println(cnf.format(1_000_000));
        System.out.println(cnf.format(1L << 30));
        System.out.println(cnf.format(1L << 40));
        System.out.println(cnf.format(1L << 50));
        System.out.println(NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT).format(12345));
        System.out.println(NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.LONG).format(1999999));
    }

    public static void testNewStringFuction(){

        System.out.println("eric".transform(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return s + " " + s.hashCode();
            }

            @Override
            public <V> Function<V, Object> compose(Function<? super V, ? extends String> before) {
                return null;
            }

            @Override
            public <V> Function<String, V> andThen(Function<? super Object, ? extends V> after) {
                return null;
            }
        }));

        System.out.println("hello".indent(3));
    }

    public static void main(String[] args) {

        // TwelveNewTest.switchTest();

        // TwelveNewTest.numberFormatTest();
        TwelveNewTest.testNewStringFuction();
    }
}

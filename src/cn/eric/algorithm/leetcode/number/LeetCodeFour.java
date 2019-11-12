package cn.eric.algorithm.leetcode.number;

import java.util.*;

/**
 * @ClassName LeetCodeFour
 * @Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * @Author YCKJ2725
 * @Date 2019/11/12
 * @Version V1.0
 **/
public class LeetCodeFour {

    static Map<String, String[]> map = new HashMap<>();

    static {
        map.put("2", new String[]{"a", "b", "c"});
        map.put("3", new String[]{"d", "e", "f"});
        map.put("4", new String[]{"h", "g", "i"});
        map.put("5", new String[]{"j", "k", "l"});
        map.put("6", new String[]{"m", "n", "o"});
        map.put("7", new String[]{"p", "q", "r", "s"});
        map.put("8", new String[]{"t", "u", "v"});
        map.put("9", new String[]{"w", "x", "y", "z"});
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if("".equals(digits)){
            return result;
        }
        return letterCombinations(digits, map, result);
    }

    private List<String> letterCombinations(String digits, Map<String, String[]> map, List<String> result) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 1) {
            String[] strings = map.get(digits);
            if (result.size() == 0) {
                for (int i = 0; i < strings.length; i++) {
                    res.add(strings[i]);
                }
            } else {
                for (int i = 0; i < strings.length; i++) {
                    for (String s : result) {
                        s = Optional.ofNullable(s).orElse("") + strings[i];
                        res.add(s);
                    }
                }

            }
            return res;
        } else {
            String[] strings = map.get(digits.substring(0, 1));
            if (result.size() == 0) {
                for (int i = 0; i < strings.length; i++) {
                    res.add(strings[i]);
                }
            } else {
                for (int i = 0; i < strings.length; i++) {
                    for (String s : result) {
                        s = Optional.ofNullable(s).orElse("") + strings[i];
                        res.add(s);
                    }
                }

            }
        }
        return letterCombinations(digits.substring(1), map, res);
    }

    public static void main(String[] args) {
        LeetCodeFour four = new LeetCodeFour();
        List<String> strings = four.letterCombinations("");
        System.out.println(strings.toString());
    }
}

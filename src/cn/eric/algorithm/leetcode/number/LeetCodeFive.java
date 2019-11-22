package cn.eric.algorithm.leetcode.number;

/**
 * @ClassName LeetCodeFive
 * @Description: palindrome 最长回文串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * @Author eric
 * @Date 2019/11/12
 * @Version V1.0
 **/
public class LeetCodeFive {

    /** 算法  1、 找到  xx  xyx 这两种基准 然后以这样为基准找到最长的字串 */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 1 || s.length() == 0){
            return s;
        }
        if(s.length() == 2){
            if(s.substring(0,1).equals(s.substring(1,2))){
                return s;
            }else{
                return s.substring(0,1);
            }
        }
        boolean has = false;
        char[] chars = s.toCharArray();

        String key = "";
        int left = 0;
        int right = 0;

        for (int i = 1; i < chars.length; i++) {
            // 如果当前的key的长度 已经超过了剩余的长度*2 就返回
            if(key.length() > ((chars.length-i)*2+1)){
                break;
            }
            // 找到基准
            if(chars[i] == chars[i-1]){
                has = true;
                left = i-1;
                right = i;
                // 找字串
                String result = findLongest(chars,left,right);
                if(result.length() > key.length()){
                    key = result;
                }
            }
            if(i+1<chars.length && chars[i+1] == chars[i-1]){
                has = true;
                left = i-1;
                right = i+1;
                // 找字串
                String result = findLongest(chars,left,right);
                if(result.length() > key.length()){
                    key = result;
                }
            }
        }



        if(!has){
            key = s.substring(0,1);
        }
        return key;
    }

    private String findLongest(char[] chars, int left, int right) {

        if(left >= 1 && right < chars.length-1){
            if(chars[left-1] == chars[right+1]){
                return findLongest(chars,left-1,right+1);
            }
        }
        return new String(chars).substring(left,right+1);
    }

    /** 算法  1、 找到  xx  xyx 这两种基准 然后以这样为基准找到最长的字串 */
    public String longestPalindrome2(String s) {
        if(s == null || s.length() == 1 || s.length() == 0){
            return s;
        }
        if(s.length() == 2){
            if(s.substring(0,1).equals(s.substring(1,2))){
                return s;
            }else{
                return s.substring(0,1);
            }
        }
        boolean has = false;
        char[] chars = s.toCharArray();

        String key = "";
        int left = 0;
        int right = 0;

        for (int i = 1; i < chars.length; i++) {
            // 如果当前的key的长度 已经超过了剩余的长度*2 就返回
            if(key.length() > ((chars.length-i)*2+1)){
                break;
            }
            // 找到基准
            if(chars[i] == chars[i-1]){
                has = true;
                left = i-1;
                right = i;
                // 找字串
                String result = findLongest(chars,left,right);
                if(result.length() > key.length()){
                    key = result;
                }
            }
            if(i+1<chars.length && chars[i+1] == chars[i-1]){
                has = true;
                left = i-1;
                right = i+1;
                // 找字串
                String result = findLongest(chars,left,right);
                if(result.length() > key.length()){
                    key = result;
                }
            }
        }



        if(!has){
            key = s.substring(0,1);
        }
        return key;
    }


    public static void main(String[] args) {
        LeetCodeFive five = new LeetCodeFive();
        String result = five.longestPalindrome("aaaa");
        System.out.println(result);
    }
}

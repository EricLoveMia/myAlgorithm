package cn.eric.algorithm.leetcode.number;

import java.util.*;

/**
 * @ClassName LeetCodeTwo
 * @Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * @Author YCKJ2725
 * @Date 2019/11/12
 * @Version V1.0
 **/
public class LeetCodeTwo {
    /**
     * 解体思路 一是要求和  二是要不重复
     */

    class TwoNums{
        private int number1;
        private int number2;

        public TwoNums(int number1, int number2) {
            this.number1 = number1;
            this.number2 = number2;
        }

        public boolean checkInNums(int number){
            if(number == number1 || number == number2){
                return true;
            }else{
                return false;
            }
        }

        public int getNumber1() {
            return number1;
        }

        public int getNumber2() {
            return number2;
        }
    }

    private static List<TwoNums> getKey(Map<TwoNums,Integer> map,Integer value){
        List<TwoNums> keys = new ArrayList<>();
        TwoNums key;
        for (Map.Entry<TwoNums,Integer> entry : map.entrySet()) {
            if(value.equals(entry.getValue())){
                key=entry.getKey();
                keys.add(key);
            }
        }
        return keys;
    }

    /**
     * 第一种算法
     * 1、将所有的二元数据编成一个map 放入对象中TwoNums
     * 2、遍历一遍数组，取出一个数字 nums[i] 然后去map中找到 value = target - nums[i] 的 key的列表
     * 3、将 i  TwoNums中的两个数字取出来 再去重
     */
    public List<List<Integer>> threeSumOne(int[] nums) {
        Set<List<Integer>> resultList = new LinkedHashSet<>();
        int target = 0;
        // 先排序
        Map<TwoNums, Integer> map = new HashMap<>();
        // 转成map
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                map.put(new TwoNums(i,j),nums[i] + nums[j]);
            }
        }
        int[] result;
        int count;
        for (int i = 0; i < nums.length; i++) {
            result = new int[3];
            result[0] = nums[i];
            count = target - nums[i];
            if (map.containsValue(count)) {
                List<TwoNums> keyList = getKey(map, count);
                for (TwoNums twoNums : keyList) {
                    if(!twoNums.checkInNums(i)){
                        result[1] = nums[twoNums.getNumber1()];
                        result[2] = nums[twoNums.getNumber2()];
                        List<Integer> integers = Arrays.asList(result[0], result[1], result[2]);
                        Collections.sort(integers);
                        resultList.add(integers);
                    }
                }
            }
        }
        return new ArrayList<>(resultList);
    }

    /***
     *   第二种做法 双指针法
     *   1、先排序
     *   2、然后取其中一个数字  位置是i  设置两个指针 分别指向i+1 和  arr.length 的位置
     *   3、通过移动指针来获得相加等于0的一组数据
     *   */
    public List<List<Integer>> threeSumTwo(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        int length = nums.length;
        if(nums == null || length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {

            if(nums[i] > 0){
                break;
            }
            // 如果重复，就再前进一位
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int Left = i+1;
            int Right = length-1;
            while(Left < Right){
                int sum = nums[i] + nums[Left] + nums[Right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i],nums[Left],nums[Right]));
                    // 去重
                    while(Left < Right && nums[Left] == nums[Left+1]){
                        Left++;
                    }
                    while(Left < Right && nums[Right] == nums[Right - 1]){
                        Right--;
                    }
                    Left++;
                    Right--;
                }
                if(sum < 0){
                    Left++;
                }
                if(sum > 0){
                    Right--;
                }
            }
        }


        return result;
    }


    public static void main(String[] args) {

        LeetCodeTwo two = new LeetCodeTwo();
        List<List<Integer>> lists = two.threeSumTwo(new int[]{-1,0,1,2,-1,-4});
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            System.out.println(integers.toString());
        }
    }

}

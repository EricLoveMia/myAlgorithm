package cn.eric.algorithm.leetcode.number;

import java.util.*;

/**
 * @ClassName LeetCodeTwo
 * @Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * @Author YCKJ2725
 * @Date 2019/11/12
 * @Version V1.0
 **/
public class LeetCodeThree {


    public static void main(String[] args) {
        LeetCodeThree two = new LeetCodeThree();
        Integer list = two.threeSumClosest(new int[]{0,2,1,-3},1);
        System.out.println(list);

    }

    public Integer threeSumClosest(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        int close = 0;
        boolean flag = false;
        int length = nums.length;
        if(nums == null || length < 3) {
            return null;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if(flag){
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
                    result = Arrays.asList(nums[i],nums[Left],nums[Right]);
                    close = 0;
                    flag = true;
                    break;
                }
                if(close == 0){
                    close = target - sum;
                    result = Arrays.asList(nums[i],nums[Left],nums[Right]);
                }
                int temp = target - sum;
                if(Math.abs(close) > Math.abs(temp)){
                    result = Arrays.asList(nums[i],nums[Left],nums[Right]);
                    close = temp;
                }
                if(sum < target){
                    while(Left < Right && nums[Left] == nums[Left + 1]){
                        Left++;
                    }
                    Left++;
                }
                if(sum > target){
                    while(Left < Right && nums[Right] == nums[Right - 1]){
                        Right--;
                    }
                    Right--;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).sum();
    }

}

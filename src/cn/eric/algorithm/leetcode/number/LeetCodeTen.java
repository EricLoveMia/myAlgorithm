package cn.eric.algorithm.leetcode.number;

import java.util.Arrays;

/**
 * @ClassName LeetCodeTen
 * @Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @Author YCKJ2725
 * @Date 2019/11/21
 * @Version V1.0
 **/
public class LeetCodeTen {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            if(i == nums.length -1){
                nums[cur++] = nums[i];
                break;
            }
            while(i+1 < nums.length && nums[i] == nums[i + 1]){
                i++;
            }
            if(i == nums.length -1){
                if(nums[i] == nums[i-1]){
                    nums[cur++] = nums[i];
                }else{
                    nums[cur++] = nums[i-1];
                    nums[cur++] = nums[i];
                }
            }else {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        LeetCodeTen ten = new LeetCodeTen();
        int[] ints = {2, 3, 4, 4, 6, 6, 7};
        int i = ten.removeDuplicates(ints);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
    }
}

package cn.eric.algorithm.leetcode.number;

import java.util.Arrays;

/**
 * @ClassName LeetCodeEleven
 * @Description:
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 * 给定 nums = [1,1,1,2,2,3],
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
。
 * @Author eric
 * @Date 2019/11/22
 * @Version V1.0
 **/
public class LeetCodeEleven {

    public int removeDuplicates(int[] nums) {

        if(nums.length == 1){
            return 1;
        }
        int cur = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            times = 0;
            if(i == nums.length -1){
                nums[cur++] = nums[i];
                break;
            }
            while(i+1 < nums.length && nums[i] == nums[i + 1]){
                if(times++ == 0) {
                    nums[cur++] = nums[i];
                }
                i++;
            }
            if(i == nums.length -1){
                if(nums[i] == nums[i-1]){
                    if(times++ >= 1) {
                        nums[cur++] = nums[i];
                    }
                }else{
                    if(times++ == 0) {
                        nums[cur++] = nums[i - 1];
                    }
                    nums[cur++] = nums[i];
                }
            }else {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        LeetCodeEleven ten = new LeetCodeEleven();
        int[] ints = {0,0,1,1,1,1,2,2,3,3};
        int i = ten.removeDuplicates(ints);
        System.out.println(i);
        System.out.println(Arrays.toString(ints));
    }
}

package cn.eric.algorithm.leetcode.number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NumberOne
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。   改成获取所有的答案
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author YCKJ2725
 * @Date 2019/11/11
 * @Version V1.0
 **/
public class LeetCodeOne {

    static int[] numbers = {3, 6, 10, 1, 4, 51, 22, 10, 8, 7, 21};
    static final int target = 9;

    /***  算法1 普通算法 首先找比基准值小的数  再去找另一个数
     *    时间复杂度  n*n
     * */

    public static int[][] computeGreedy() {
        int[][] result = new int[numbers.length][2];
        int key = 0;
        int rest = 0;
        for (int i = 0; i < numbers.length; i++) {
            //  是否比基准数小  这里有问题 如果是负数呢 如果是比如 target = 9   10 +  -1 也是9 所以if (numbers[i] <= target) 这个有问题
            if (numbers[i] <= target) {
                rest = target - numbers[i];
                for (int j = i + 1; j < numbers.length; j++) {
                    if (numbers[j] == rest) {
                        result[key++] = new int[]{i, j};
                    }
                }
            }
        }
        return result;
    }

    /***  算法1 hash法  首先找比基准值小的数  再去找另一个数
     *    时间复杂度 n
     * */
    public static int[][] computeByHashMap() {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] result = new int[numbers.length][2];
        int key = 0;
        int rest = 0;
        // 转成map
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            rest = target - numbers[i];
            if (map.get(rest) != null && map.get(rest) > i) {
                result[key++] = new int[]{i, map.get(rest)};
            }
        }
        return result;
    }

    /** 只返回一个解的版本 注意还有负数 */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int key = 0;
        int rest = 0;
        // 转成map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            rest = target - nums[i];
            if (map.get(rest) != null && map.get(rest) > i) {
                return new int[]{i, map.get(rest)};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] result = LeetCodeOne.computeByHashMap();
        for(int i=0;i<result.length;i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        LeetCodeOne.twoSum(new int[]{-1, -2, -3, -4, -5}, -8);
    }
}

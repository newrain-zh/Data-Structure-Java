package org.newrain.code.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NewRain
 * @description 两数之和
 * @link <a href="https://www.lintcode.com/problem/56">lintcode</a>
 */
public class TwoSum {

    /**
     * 使用KV结构
     *
     * @param nums
     * @param target
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
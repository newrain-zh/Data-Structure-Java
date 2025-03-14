package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * @author alex
 * @description 三个数的最大乘积
 * @link <a href="https://leetcode.cn/problems/maximum-product-of-three-numbers/"></a>
 */
public class MaximumProduct {


    public static int maximumProduct(int[] nums) {
        //特殊情况判断
        if (nums.length == 3) {
            int v = 1;
            for (int num : nums) {
                v *= num;
            }
            return v;
        }
        Arrays.sort(nums);
        //全为负数
        int len = nums.length;
        return Math.max(nums[0] * nums[1] * nums[len - 1], nums[len - 1] * nums[len - 2] * nums[len - 3]);

    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1, -2, -3, -4}));
    }
}
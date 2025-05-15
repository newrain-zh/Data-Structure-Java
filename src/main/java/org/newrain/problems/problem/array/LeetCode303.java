package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * LeetCode.303 区域和检索 - 数组不可变
 */
public class LeetCode303 {

    int[] prefixSum;


    public LeetCode303(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]; // 提前计算好每一位的前缀和
        }
        System.out.println(Arrays.toString(prefixSum));
    }

    /**
     * •	prefixSum[right + 1] 代表 nums[0] 到 nums[right] 的和。
     * •	prefixSum[left] 代表 nums[0] 到 nums[left-1] 的和。
     * •	两者相减，即得到 nums[left] 到 nums[right] 的总和。
     */
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    public static void main(String[] args) {
        LeetCode303 leetCode303 = new LeetCode303(new int[]{-2, 0, 3, -5, 2, -1});
    }
}
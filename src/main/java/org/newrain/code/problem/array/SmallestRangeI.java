package org.newrain.code.problem.array;


/**
 * 题目：leetcode.908 最小差值 I
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。
 * 将 nums[i] 改为 nums[i] + x ，
 * 其中 x 是一个范围为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 * nums 的 分数 是 nums 中最大和最小元素的差值。
 * 在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
 */
public class SmallestRangeI {

    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        // 计算调整后的最大值和最小值的差
        max = max - k;
        min = min + k;
        // 如果差值是负的或零，那么最小分数就是0
        // 否则，最小分数就是调整后的差值
        return Math.max(0, max - min);
    }
}
package org.newrain.problems.problem.array;

/**
 * 303. 区域和检索 - 数组不可变
 */
public class LeetCode303 {
    int[] sums;


    public LeetCode303(int[] nums) {
        sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i]; // 提前计算好每一位的前缀和
        }
    }

    /**
     * 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，
     * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
     *
     * @param left
     * @param right
     * @return
     */
    public int sumRange(int left, int right) {
        return sums[right + 1] - sums[left];
    }
}
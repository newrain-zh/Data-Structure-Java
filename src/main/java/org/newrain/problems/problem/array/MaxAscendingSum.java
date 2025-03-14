package org.newrain.problems.problem.array;

/**
 * leetcode.1800 最大升序子数组和
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * 子数组是数组中的一个连续数字序列。
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），
 * numsi  < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 */
public class MaxAscendingSum {

    public static int maxAscendingSum(int[] nums) {
        int ans = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {//如果是升序
                sum += nums[i];
            } else {
                if (sum > ans) {
                    ans = sum;
                }
                sum = nums[i];
            }
        }
        return Math.max(sum, ans); //如果是最后一位还是升序 这里还是需要比较最大值和sum值
    }

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));//65
    }
}
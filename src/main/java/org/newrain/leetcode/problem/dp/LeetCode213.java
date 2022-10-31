package org.newrain.leetcode.problem.dp;


import java.util.Arrays;


public class LeetCode213 {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //抢劫首不抢劫尾
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        //抢尾不抢劫首
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(getResult(nums1), getResult(nums2));
    }

    public static int getResult(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3};
        System.out.println(rob(test));
    }
}

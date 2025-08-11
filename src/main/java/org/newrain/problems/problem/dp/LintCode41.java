package org.newrain.problems.problem.dp;

public class LintCode41 {


    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            ans   = Math.max(ans, dp[i]);
        }
        return Math.max(ans, dp[0]);
    }

    public static void main(String[] args) {
//        System.out.println(maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
        System.out.println(maxSubArray(new int[]{5, -10, 4}));

    }
}
package org.newrain.code.problem.dp;

public class LeetCode740 {

    public static int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }

        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int[] dp = new int[sum.length];
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);
        for (int i = 2; i < sum.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i]);
        }
        return dp[sum.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 2};
        System.out.println(deleteAndEarn(nums));
    }
}

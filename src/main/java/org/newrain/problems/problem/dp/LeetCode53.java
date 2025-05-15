package org.newrain.problems.problem.dp;

/**
 * @author NewRain
 * @description
 * @link
 */
public class LeetCode53 {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > max) {
                max = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * 动态规划解法
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(dp[i], max);
        }
        return Math.max(dp[0], max);


    }

    public static void main(String[] args) {
        int[] nums = {-2, -3, -5, -5};
        System.out.println(maxSubArray(nums));
    }
}
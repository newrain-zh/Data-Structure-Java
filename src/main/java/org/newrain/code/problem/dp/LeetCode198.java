package org.newrain.code.problem.dp;

/**
 *
 *
 *推到公式
 [2,7,9,3,1]
 dp[1] = 2
 dp[2] = max(2,7) = 7 = max (dp[1],7)
 dp[3] = max(2+9,7) = 11 = max (dp[1]+9,dp[2])
 dp[4] = max(2+9,7+3) = 11 = max (dp[2]+3),dp[3]
 dp[5] = max(2+9+1,7+3) = 12 =max(dp[3]+1,dp[4])
 * @author zhiqin.zhang
 */
public class LeetCode198 {

    public static int rob(int[] nums) {
        //首先明确边界问题 只有一间的情况 直接返回金额
        if (nums.length == 1) {
            return nums[0];
        }
        //只有2个房间的情况下 返回金额最大的那个
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //保存最优解
        int[] dp = new int[nums.length];
        //记录一个房间和2个房间的金额用于计算
        dp[0] = nums[0];
        //2个房间的最优解为0 1位置的数字哪个最大
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(rob(nums));
    }
}

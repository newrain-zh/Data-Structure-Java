package org.newrain.problems.problem.array;


/**
 * leetcode.使用最小花费爬楼梯
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class MinCostClimbingStairs {

    /**
     * 动态规划解法
     * <p>
     * 定义状态：设 dp[i] 为到达第 i 个台阶所需的最低花费。
     * <p>
     *  e
     * 状态转移方程：对于第 i 个台阶，你可以从第 i-1 或 i-2 个台阶上来。
     * 因此，到达第 i 个台阶的最低花费是到达 i-1 或 i-2 个台阶的最低花费加上当前台阶的花费，
     * 即 dp[i] = cost[i] + min(dp[i-1], dp[i-2])。
     * <p>
     * 初始化：你可以从第 0 个或第 1 个台阶开始，所以 dp[0] = cost[0] 和 dp[1] = cost[1]。
     * <p>
     * 计算结果：最后你会到达最顶部，这可以从最后一个台阶或倒数第二个台阶达到，
     * 所以最终结果是 min(dp[cost.length - 1], dp[cost.length - 2])。
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

}
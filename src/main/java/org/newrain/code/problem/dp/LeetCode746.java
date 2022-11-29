package org.newrain.code.problem.dp;


/**
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 */
public class LeetCode746 {


    public static int minCostClimbingStairs(int[] cost) {
        //保存到达每一步的体力值
        int[] dp = new int[cost.length];
        //初始化 0 1号位置 值等同于该处的体力值
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            //计算到达当前步数的最优解
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //到达顶部时 可以由倒数第二或者倒数第一的位置跳跃 取这2步的最小值
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static int minCostClimbingStairs2(int[] cost) {
        //保存到达每一步的体力值
        int[] dp = new int[cost.length + 1];
        //初始化 0 1号位置 值等同于该处的体力值
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            //计算到达该步的最优解
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        //到达顶部时 可以由倒数第二或者倒数第一的位置跳跃 取这2步的最小值
        return dp[cost.length];
    }


    public static int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= n; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        return curr;
    }


    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}

package org.newrain.leetcode.problem.dp;

/**
 * @author zhiqin.zhang
 */
public class LeetCode62 {

    public static int uniquePaths(int m, int n) {
        //定义数组记录到达每条网格的路径
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //起始路径是1
                if (i == 0) {
                    dp[0][j] = 1;
                    continue;
                }
                //第一行因为只能向右移动 所以等于前面的路径加1
                if (j == 0) {
                    dp[i][0] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}

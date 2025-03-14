package org.newrain.problems.offer;

public class MaxValue {


    public static int maxValue(int[][] grid) {
        //行
        int row = grid.length;
        //列
        int col = grid[0].length;
        //保存每走一步的最大值
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //左上角的开始一格不用记录
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    //第一行的值为向右累加 等于当前值加上左边位置的累加值
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    //这里计算二维数组的中的每个开始值
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
        }
        return dp[row - 1][col - 1];
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(maxValue(grid));

    }

}
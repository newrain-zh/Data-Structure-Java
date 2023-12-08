package org.newrain.code.problem.array;

/**
 * 题目：leetcode.1351 统计有序矩阵中的负数
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * 示例 1：
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 */
public class CountNegatives {

    public static int countNegatives(int[][] grid) {
        int ans = 0;
        int n = grid[0].length;
        for (int[] ints : grid) { //按行遍历
            if (ints[n - 1] > 0) { //最后一位为整数 则跳过遍历
                continue;
            }
            for (int j = n - 1; j >= 0; j--) {//从后向前遍历，碰到整数则跳出
                if (ints[j] >= 0) {
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
    }

}
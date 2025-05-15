package org.newrain.problems.problem.array;

/**
 * LeetCode.463 岛屿的周长
 * <a href="https://leetcode.cn/problems/island-perimeter/description/">...</a>
 */
public class LeetCode463 {

    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int rol = grid[0].length;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < rol; j++) {
                if (grid[i][j] == 1) { // 陆地
                    ans += 4;
                    if (i >= 1 && grid[i - 1][j] == 1) { // 如果大于第二行 就要判断它的上方有没有陆地 上方和下方岛屿会有重合 各减去一边
                        ans -= 2;
                    }
                    if (j >= 1 && grid[i][j - 1] == 1) { // 如果左边有陆地且不是最左边的岛屿 当前岛屿方和右边岛屿会有重合 各减去一边
                        ans -= 2;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
        System.out.println(islandPerimeter(new int[][]{{1}}));
        System.out.println(islandPerimeter(new int[][]{{1, 0}}));
    }
}
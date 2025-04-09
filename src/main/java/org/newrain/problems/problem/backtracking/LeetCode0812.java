package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后问题
 */
public class LeetCode0812 {

    private final List<List<String>> ans = new ArrayList<>();
    private       boolean[]          usedCols;  // 标记已占用的列
    private       boolean[]          diag1; // 标记对角线（左上到右下） ↘
    private       boolean[]          diag2; // 标记对角线 (右上到左下) ↙


    public List<List<String>> solveNQueens(int n) {
        // 先准备棋盘
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        usedCols = new boolean[n];
        diag1    = new boolean[2 * n];
        diag2    = new boolean[2 * n];
        backtrack1(chessboard, n, 0);
        return ans;
    }

    /**
     * 未剪枝代码
     *
     * @param chessboard
     * @param n
     * @param row
     */
    public void backtrack(char[][] chessboard, int n, int row) {
        if (row == n) {
            ans.add(covert(chessboard));
            return;
        }
        // 遍历行
        for (int col = 0; col < n; col++) {
            if (isValid(chessboard, row, col, n)) { // 判断当前位置是否有效
                chessboard[row][col] = 'Q';
                backtrack(chessboard, n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }

    public void backtrack1(char[][] chessboard, int n, int row) {
        if (row == n) {
            ans.add(covert(chessboard));
            return;
        }
        // 遍历行
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;  // 主对角线 ↘
            int d2 = row + col;   // 副对角线
            if (usedCols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            chessboard[row][col] = 'Q';
            usedCols[col]        = true;
            diag1[d1]            = true;
            diag2[d2]            = true;
            backtrack1(chessboard, n, row + 1);
            usedCols[col]        = false;
            diag1[d1]            = false;
            diag2[d2]            = false;
            chessboard[row][col] = '.';
        }
    }

    /**
     * 判断放置位置是否有效
     *
     * @param chars 棋盘
     * @param row   行
     * @param col   列
     * @param n     棋盘大小
     * @return
     */
    public boolean isValid(char[][] chars, int row, int col, int n) {
        // 判断同一列 是否放置了皇后
        for (char[] c : chars) {
            if (c[col] == 'Q') {
                return false;
            }
        }
        // 判断上斜方向 ↖
        for (int x = row, y = col; x >= 0 && y >= 0; y--, x--) {
            if (chars[x][y] == 'Q') {
                return false;
            }
        }
        // 判断下斜方向 ↗
        for (int x = row, y = col; x >= 0 && y < n; x--, y++) {
            if (chars[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }


    public List<String> covert(char[][] chessboard) {
        List<String> ret = new ArrayList<>();
        for (char[] chars : chessboard) {
            ret.add(new String(chars));
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode0812       leetCode0812 = new LeetCode0812();
        List<List<String>> list         = leetCode0812.solveNQueens(4);
        list.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }


}
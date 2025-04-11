package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode.52 N皇后问题
 */
public class LeetCode52 {

    List<List<String>> ret = new ArrayList<>();
    boolean[]          usedCols;

    public int totalNQueens(int n) {
        // 先生成棋盘
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        usedCols = new boolean[n];
        backtrack(chessboard, 0, n);
        return ret.size();
    }

    public void backtrack(char[][] chessboard, int row, int n) {
        if (row == n) {
            ret.add(genAns(chessboard));
            return;
        }
        for (int i = 0; i < chessboard.length; i++) {
            if (usedCols[i]) {
                continue;
            }
            if (isValid(chessboard, row, i, n)) {
                chessboard[row][i] = 'Q';
                usedCols[i]        = true;
                backtrack(chessboard, row + 1, n);
                usedCols[i]        = false;
                chessboard[row][i] = '.';
            }
        }
    }

    public List<String> genAns(char[][] chessboard) {
        List<String> curr = new ArrayList<>(chessboard.length);
        for (char[] chars : chessboard) {
            curr.add(new String(chars));
        }
        return curr;
    }


    /*
     判断放置的位置是否有效
     */
    public boolean isValid(char[][] chessboard, int row, int col, int n) {

        // 先判断同一列的上方
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 判断对角线 ↖
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (chessboard[x][y] == 'Q') {
                return false;
            }
        }
        // 判断对角线 ↗
        for (int x = row, y = col; x >= 0 && y < n; x--, y++) {
            if (chessboard[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode52().totalNQueens(4));
    }
}
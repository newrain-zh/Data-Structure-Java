package org.newrain.problems.problem.backtracking;

/**
 * 解数独
 */
public class LeetCode37 {


    public void solveSudoku(char[][] board) {
        backtrack(board, 0);
    }

    public boolean backtrack(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }
        int row = pos / 9;
        int col = pos % 9;
        if (board[row][col] != '.') {
            return backtrack(board, pos + 1);
        }
        for (char num = '1'; num <= '9'; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                if (backtrack(board, pos + 1)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }


    public boolean isValid(char[][] board, int row, int col, char val) {
        // 先检查行
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }

        }
        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }

        }
        // 检查 3*3的格子
        int startRow = 3 * (row / 3);
        int startCol = 3 * (col / 3);
        for (int x = startRow; x < startRow + 3; x++) {
            for (int y = startCol; y < startCol + 3; y++) {
                if (board[x][y] == val) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(1 / 9);
        System.out.println(2 / 9);
        System.out.println(3 / 9);

        System.out.println(1 % 9);
        System.out.println(2 % 9);
        System.out.println(3 % 9);
    }
}
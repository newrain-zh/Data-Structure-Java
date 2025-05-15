package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 8皇后问题
 */
public class InterviewQuestions0812 {

    List<List<String>> ans = new ArrayList<>();

    private int chessboardSize = 0; // 棋盘大小

    private boolean[] usedCols;

    private boolean[] usedD1;
    private boolean[] usedD2;

    public List<List<String>> solveNQueens(int n) {
        this.chessboardSize = n;
        this.usedD1         = new boolean[n * 2];
        this.usedD2         = new boolean[n * 2];
        this.usedCols       = new boolean[n];
        char[][] chessboard = new char[n][n];
        for (char[] chars : chessboard) {
            Arrays.fill(chars, '.');
        }
        backtracking(chessboard, 0);
        return ans;
    }

    public void backtracking1(char[][] chessboard, int row) {
        if (row == chessboardSize) {
            ans.add(getChessboard(chessboard));
            return;
        }
        for (int col = 0; col < chessboard.length; col++) {
            if (isValid(chessboard, row, col)) {
                chessboard[row][col] = 'Q';
                backtracking(chessboard, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }


    public void backtracking(char[][] chessboard, int row) {
        if (row == chessboardSize) {
            ans.add(getChessboard(chessboard));
            return;
        }
        for (int col = 0; col < chessboard.length; col++) {

            int d1 = row + col;
            int d2 = row - col + chessboardSize;
            if (usedCols[col] || usedD2[d2] || usedD1[d1]) {
                continue;
            }
            chessboard[row][col] = 'Q';
            usedCols[col]        = true;
            usedD1[d1]           = true;
            usedD2[d2]           = true;
            backtracking(chessboard, row + 1);
            chessboard[row][col] = '.';
            usedCols[col]        = false;
            usedD1[d1]           = false;
            usedD2[d2]           = false;
            /*if (isValid(chessboard, row, col)) {

            }*/
        }
    }

    public List<String> getChessboard(char[][] chessboard) {
        List<String> result = new ArrayList<>(chessboardSize);
        for (char[] chars : chessboard) {
            result.add(new String(chars));
        }
        return result;
    }


    public boolean isValid(char[][] chessboard, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        for (int x = row, y = col; x >= 0 && y >= 0; x--, y--) {
            if (chessboard[x][y] == 'Q') {
                return false;
            }
        }

        for (int x = row, y = col; x >= 0 && y < chessboardSize; x--, y++) {
            if (chessboard[x][y] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> list = new InterviewQuestions0812().solveNQueens(4);
        list.forEach(v -> System.out.println(v.toString()));

    }
}
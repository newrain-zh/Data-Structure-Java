package org.newrain.problems.problem.array;

/**
 * 566. 重塑矩阵
 */
public class LeetCode566 {


    /**
     * @param mat
     * @param r   行数
     * @param c   列数
     * @return
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int x = 0; x < m * n; x++) {
            res[x / c][x % c] = mat[x / n][x % n];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2 / 4);
    }
}
package org.newrain.code.offer;

public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] arraty : matrix) {
            if (target >= arraty[0] && target <= arraty[arraty.length - 1]) {
                for (int k : arraty) {
                    if (target == k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] test = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(test, 20));
        System.out.println(findNumberIn2DArray(test, 5));
        int[][] test1 = new int[][]{};
        System.out.println(findNumberIn2DArray(test1, 5));
    }
}

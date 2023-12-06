package org.newrain.example.base;


/**
 * 二维数组的一些操作
 */
public class TwoDimensionalArray {


    /**
     * 二维数组按行遍历
     */
    public static void foreachByRow(int[][] arr) {
        int row = arr.length, col = arr[0].length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                stringBuilder.append(arr[i][j]).append(",");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    /**
     * 二维数组按列遍历
     * @param arr
     */
    public static void foreachByCol(int[][] arr) {
        int rows = arr.length, col = arr[0].length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < rows; j++) {
                stringBuilder.append(arr[j][i]).append(",");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
//        foreachByRow(new int[][]{{1, 2, 4}, {3, 3, 1}});
        foreachByCol(new int[][]{{1, 2, 4}, {3, 3, 1}});

    }
}
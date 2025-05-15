package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.List;


/**
 * leetcode.1380 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * 幸运数 是指矩阵中满足同时下列两个条件的元素：
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * [
 * [3,7,8],
 * [9,11,13],
 * [15,16,17]
 * ]
 */
public class LuckyNumbers {

    /**
     * 预先计算出每列的最大值
     *
     * @param matrix
     * @return
     */
    public static List<Integer> luckyNumbers(int[][] matrix) {
        int rowLen = matrix[0].length;
        int[] rowMaxArr = new int[matrix[0].length];
        for (int i = 0; i < rowLen; i++) {//遍历列
            int currRowMax = 0;
            for (int[] ints : matrix) {//遍历行
                if (ints[i] > currRowMax) {
                    currRowMax = ints[i];
                }
            }
            rowMaxArr[i] = currRowMax;
        }
        List<Integer> ans = new ArrayList<>();
        for (int[] lineRow : matrix) {
            int min = lineRow[0];//当前行的最小值
            int minP = 0;
            for (int j = 1; j < lineRow.length; j++) {
                if (lineRow[j] < min) {
                    min = lineRow[j];
                    minP = j;
                }
            }
            //根据最小值的列比对是是否是该列的最大值
            if (rowMaxArr[minP] == min) {
                ans.add(min);
            }
        }
        return ans;
    }

    /**
     * * [
     * * [3,7,8],
     * * [9,11,13],
     * * [15,16,17]
     * * ]
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[][] arr = new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
       /* for (int i = 0; i < arr.length; i++) {
            int[] ans = new int[arr[0].length];
            for (int j = 0; j < arr.length; j++) {
                ans[j] = arr[j][i];
            }
            System.out.println(Arrays.toString(ans));
        }*/
        System.out.println(luckyNumbers(arr));
    }
}
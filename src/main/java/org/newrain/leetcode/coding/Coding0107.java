package org.newrain.leetcode.coding;


/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
 * 请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 *
 * @author NewRain
 * @description 旋转矩阵
 * @link <a href="https://leetcode.cn/problems/rotate-matrix-lcci/">...</a>
 */
public class Coding0107 {

    /**
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ],
     * <p>
     * matrix[0] =[ matrix[3][0] , matrix[2][0], matrix[1][0]  ]
     * matrix[1] =[ matrix[3][1] , matrix[2][1] , matrix[1][1] ]
     * matrix[2] =[ matrix[3][2] , matrix[2][2] , matrix[1][2] ]
     * <p>
     * [
     * [7,4,1],
     * [8,5,2],
     * [9,6,3]
     * ]
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            int[] sub = matrix[i];
            int last = matrix.length - 1;
            for (int j = 0; j < sub.length; j++) {
                //当前值
                int temp = matrix[i][j];
                matrix[i][j] = matrix[last][i];
                matrix[last][i] = temp;
                last = last - 1;
            }
        }
    }


    public static void main(String[] args) {
        int[][] temp = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(temp);
        for (int i = 0; i < temp.length; i++) {
            int[] ints = temp[i];
            for (int n : ints) {
                System.out.print(n + ",");
            }
            System.out.println();

        }
    }
}

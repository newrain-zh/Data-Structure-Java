package org.newrain.code.problem.array;

import java.util.Arrays;

public class SwapIntegers {


    /**
     * 临时变量
     *
     * @param a:      An integer array
     * @param index1: the first index
     * @param index2: the second index
     * @return: nothing
     */
    public static void swapIntegers(int[] a, int index1, int index2) {
        //先获取index1位置的值
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        swapIntegers(new int[]{1, 2, 3, 4}, 2, 3);
    }
}
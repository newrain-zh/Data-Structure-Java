package org.newrain.code.problem.array;

import java.util.Arrays;

/**
 * 存在一个数组 arr。你需要对数组中的除了头尾元素之外的元素进行变换，直至数组无法再进行变换。
 *
 * 其中变换的规则如下：
 *
 * 如果一个数同时比其相邻的两个数都小，那么这个数需要加 1
 * 如果一个数同时比其相邻的两个数大，那么这个数需要减 1
 * 最后返回无法变换的最终数组。
 */
public class TransformArray {


    /**
     * @param arr: the original array
     * @return: the final array
     */
    public static int[] transformArray(int[] arr) {
        boolean b = true;
        int[] arr1 = arr.clone();
        while (b) {
            b = false;
            for (int i = 1; i < arr.length - 1; i++) {
                //如果一个数同时比其相邻的两个数都小，那么这个数需要加 1
                if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    arr1[i] = arr[i] + 1;
                    b = true;
                } else if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    arr1[i] = arr[i] - 1;
                    b = true;
                }
            }
            arr = arr1.clone();
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(transformArray(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(transformArray(new int[]{5, 12, 3, 8, 9})));
        System.out.println(Arrays.toString(transformArray(new int[]{9, 6, 7, 10, 13, 14})));

    }
}
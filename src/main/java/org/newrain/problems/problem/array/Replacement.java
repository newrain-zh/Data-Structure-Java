package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * 给定两个数组 arr1 和 arr2 ，其中数组 arr1 的长度大于等于数组 arr2 的长度，
 * 请你将数组 arr2 中的数据放入数组 arr1 的后面（替换）。
 */
public class Replacement {

    public static int[] replacement(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            return arr1;
        }
        int right = 0;
        //left 计算的起始位置
        for (int left = arr1.length - arr2.length; left < arr1.length; left++) {
            arr1[left] = arr2[right];
            right++;
        }
        return arr1;
    }

    public static int[] replacement1(int[] arr1, int[] arr2) {
        System.arraycopy(arr2, 0, arr1, arr1.length - arr2.length, arr2.length);
        return arr1;
    }

    public static int[] replacement2(int[] arr1, int[] arr2) {
        if (arr1.length < arr2.length) {
            return arr1;
        }
        int diff = arr1.length - arr2.length;
        for (int i = 0; i < arr2.length; i++) {
            arr1[i + diff] = arr2[i];
        }
        return arr1;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{5, 10, 7, 1, 8, 9};
        int[] arr2 = new int[]{5, 10, 9, 8, 7};
        //5, 5, 10, 9, 8, 7
        System.out.println(Arrays.toString(replacement(arr1, arr2)));
        System.out.println(Arrays.toString(replacement2(arr1, arr2)));
    }

}
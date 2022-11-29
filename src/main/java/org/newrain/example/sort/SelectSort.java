package org.newrain.example.sort;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 选择排序
 */
public class SelectSort {

    /**
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            //当前最小值位置
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            //将最小值交换到前面
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectSort(new int[]{5, 3, 2, 1, 9})));
    }
}

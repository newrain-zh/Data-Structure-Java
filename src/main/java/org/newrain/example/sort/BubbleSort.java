package org.newrain.example.sort;

import java.util.Arrays;

/**
 * @author newRain
 * @description 冒泡排序
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            //len -i 是可以减少循环次数 因为每次交换最大值都会交换到最后
            for (int j = 0; j < len - i; j++) {
                //相邻元素交换元素
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    /**
     * 改进版本，利用变量isSort来标记数组是否已经有序，这样避免了多余的循环。
     *
     * @param arr
     * @return
     */
    public static int[] bubbleSort1(int[] arr) {
        int len = arr.length - 1;
        boolean isSort = true;
        for (int i = 0; i < len; i++) {
            //len -i 是可以减少循环次数 因为每次交换最大值都会交换到最后
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSort = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                if (isSort) {
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    public static void main(String[] args) {
        bubbleSort1(new int[]{5, 3, 6, 2, 1});
    }
}

package org.newrain.example.sort;

import java.util.Arrays;

/**
 * @author newRain
 * @description 快速排序
 */
public class QuickSort {

    public static void quickSort(int start, int end, int[] arr) {
        if (start >= end) {
            return;
        }
        int index = partition(arr, start, end);
        System.out.println(index);
        quickSort(start, index - 1, arr);
        quickSort(index + 1, end, arr);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int mark = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                mark += 1;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) {
        int[] array = {4, 3, 2, 5, 6, 7, 8, 1};
        quickSort(0, array.length, array);
        System.out.println(Arrays.toString(array));
    }

}

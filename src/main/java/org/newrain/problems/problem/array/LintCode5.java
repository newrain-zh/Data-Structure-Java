package org.newrain.problems.problem.array;

import java.util.Arrays;

public class LintCode5 {


    public static int kthLargestElement(int k, int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
        return nums[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(kthLargestElement(1, new int[]{3, 4, 2, 1}));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i     = low - 1; // 小于基准值的末尾
        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) { // 这里更改排序规则 从小往大 还是从大往小
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;

    }


    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
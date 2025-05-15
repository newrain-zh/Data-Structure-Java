package org.newrain.problems.problem.array;

import java.util.Random;

/**
 * LeetCode.215 数组中的第K个最大元素
 */
public class LeetCode215 {


    public int findKthLargest(int[] nums, int k) {
        return 0;
    }

    public int quickSort(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        Random random     = new Random();
        int    pivotIndex = left + random.nextInt(right - left + 1);
        return 0;
    }

    public int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right); // 将 pivot移动到末尾

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        return 0;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
package org.newrain.leetcode.practise.array;

import java.util.Arrays;

public class LeetCode34 {


    public static int[] searchRange(int[] nums, int target) {
        int[] count = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                count[0] = left + 1;
                while (right < nums.length && nums[right] == target) {
                    right++;
                }
                count[1] = right - 1;
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return count;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int[] arr = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                if (arr[0] > 0) {
                    arr[1] = i;
                } else {
                    arr[0] = i;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange1(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));

    }
}

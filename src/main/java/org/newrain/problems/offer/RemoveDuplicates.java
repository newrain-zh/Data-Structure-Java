package org.newrain.problems.offer;

import java.util.Arrays;

public class RemoveDuplicates {


    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (nums.length <= 2) {
            return n;
        }

        int fast = 2, slow = 2;
        System.out.println(Arrays.toString(nums));
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }
}
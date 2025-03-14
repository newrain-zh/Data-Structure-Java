package org.newrain.problems.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == num) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!set.contains(target - num)) {
                set.add(num);
            } else {
                return new int[]{num, target - num};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum1(new int[]{2, 7, 11, 15}, 9)));
    }
}
package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;

/*
41. 缺失的第一个正数
 */
public class LeetCode41 {

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> dict = new HashSet<>();
        int          max  = 0;
        for (int num : nums) {
            dict.add(num);
            max = Math.max(num, max);
        }
        for (int i = 0; i <= max; i++) {
            if (!dict.contains(i + 1)) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

}
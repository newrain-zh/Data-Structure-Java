package org.newrain.code.problem.array;


import java.util.HashSet;
import java.util.Set;

/**
 * 题目：leetcode.2395 和相等的子数组
 * 给你一个下标从 0 开始的整数数组 nums ，判断是否存在 两个 长度为 2 的子数组且它们的 和 相等。注意，这两个子数组起始位置的下标必须 不相同 。
 * 如果这样的子数组存在，请返回 true，否则返回 false 。
 * 子数组 是一个数组中一段连续非空的元素组成的序列。
 */
public class FindSubarrays {
    public static boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int e = nums[i] + nums[i + 1];
            if (!set.add(e)) {
                return true;
            }
            set.add(e);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findSubarrays(new int[]{4, 2, 4}));
        System.out.println(findSubarrays(new int[]{1, 2, 3, 4, 5, 6}));
    }
}
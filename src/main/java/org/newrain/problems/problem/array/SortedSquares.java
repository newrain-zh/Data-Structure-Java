package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * leetcode.977 有序的平方数组
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        System.out.println((-4)^2);
    }

}
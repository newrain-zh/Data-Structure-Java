package org.newrain.problems.problem.array;


import java.util.Arrays;

/**
 * 题目：leetcode.1929 数组串联
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，
 * 数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
 */
public class GetConcatenation {


    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        for (int i = nums.length, p = 0; i < ans.length; i++,p++) {
            ans[i] = nums[p];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
    }
}
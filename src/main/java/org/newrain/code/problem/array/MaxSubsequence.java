package org.newrain.code.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：找到和最大的长度为 K 的子序列
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 */
public class MaxSubsequence {

    public static int[] maxSubsequence(int[] nums, int k) {
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        Arrays.sort(copyNums);
        Map<Integer, Integer> countMap = new HashMap<>(k);
        for (int i = copyNums.length - 1; i >= nums.length - k; i--) {
            countMap.put(copyNums[i], countMap.getOrDefault(copyNums[i], 0) + 1);
        }
        int[] ans = new int[k];
        int index = 0;
        for (int num : nums) {
            if (countMap.getOrDefault(num, 0) > 0 && index < k) {
                countMap.put(num, countMap.getOrDefault(num, 0) - 1);
                ans[index] = num;
                index++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(maxSubsequence(new int[]{2, 1, 3, 3}, 2)));//[3,3]
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1, -2, 3, 4}, 3)));//[-1,3,4]
        //-2,-1,3,4
    }
}
package org.newrain.problems.problem.array;

import java.util.*;

/**
 * leetcode.2089 找出数组排序后的目标下标
 * 给你一个下标从 0 开始的整数数组 nums 以及一个目标元素 target 。
 *
 * 目标下标 是一个满足 nums[i] == target 的下标 i 。
 *
 * 将 nums 按 非递减 顺序排序后，返回由 nums 中目标下标组成的列表。
 * 如果不存在目标下标，返回一个 空 列表。返回的列表必须按 递增 顺序排列。
 */
public class TargetIndices {

    public static List<Integer> targetIndices(int[] nums, int target) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        if (countMap.get(target) == null) {
            return new ArrayList<>(0);
        }
        Arrays.sort(nums);
        int start = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                start = i;
                break;
            }
        }
        //判断出现次数
        int count = countMap.get(target);
        if (count > 1) {
            for (int i = 0; i < count; i++) {
                ans.add(start + i);
            }
            return ans;
        }
        ans.add(start);
        return ans;
    }

    /**
     * 最优解法
     *
     * @param nums
     * @param target
     * @return
     */
    public List<Integer> targetIndices1(int[] nums, int target) {
        //count =出现次数 lessthan 小于目标的数
        //通过lessthan 可以知道target在排序后的位置
        int count = 0, lessthan = 0;
        for (int n : nums) {
            if (n == target) count++;
            if (n < target) lessthan++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(lessthan++);
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1, 2, 5, 2, 3}, 3));
    }
}
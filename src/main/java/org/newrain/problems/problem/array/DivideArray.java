package org.newrain.problems.problem.array;


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode.2206 将数组划分成相等数对
 * 描述：
 * 给你一个整数数组 nums ，它包含 2 * n 个整数。
 * 你需要将 nums 划分成 n 个数对，满足：
 * 每个元素 只属于一个 数对。
 * 同一数对中的元素 相等 。
 * 如果可以将 nums 划分成 n 个数对，请你返回 true ，否则返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,3,2,2,2]
 * 输出：true
 * 解释：
 * nums 中总共有 6 个元素，所以它们应该被划分成 6 / 2 = 3 个数对。
 * nums 可以划分成 (2, 2) ，(3, 3) 和 (2, 2) ，满足所有要求。
 */
public class DivideArray {


    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>(nums.length);
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Integer n : countMap.keySet()) {
            int x = countMap.get(n);
            if ((x & 1) == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最优解
     *
     * @param nums
     * @return
     */
    public boolean divideArray1(int[] nums) {
        int[] dict = new int[501];
        for (int num : nums) {
            dict[num]++;
        }
        for (int j : dict) {
            if (j > 0 && (j & 1) == 1) {
                return false;
            }
        }
        return true;

    }
}
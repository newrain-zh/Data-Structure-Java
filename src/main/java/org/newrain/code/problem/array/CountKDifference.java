package org.newrain.code.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：leetcode.2006 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，
 * 满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 */
public class CountKDifference {

    public static int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * 字典统计解法
     *
     * @param nums
     * @param k
     * @return
     */
    public static int countKDifference1(int[] nums, int k) {
        int ans = 0;
        int[] hash = new int[105];
        for (int num : nums) {
            if (num + k < hash.length) {
                ans += hash[num + k];
            }
            if (num - k >= 0) {
                ans += hash[num - k];
            }
            hash[num]++;
        }
        return ans;
    }

    public static int countKDifference2(int[] nums, int k) {
        int count = 0; // 初始化计数器为0
        Map<Integer, Integer> numCount = new HashMap<>(); // 创建一个HashMap，用于存储数组中每个数字出现的次数

        for (int num : nums) { // 遍历数组中的每个元素
            int diff1 = num - k; // 计算与当前元素相差k的值
            int diff2 = num + k; // 计算与当前元素相加k的值

            count += numCount.getOrDefault(diff1, 0); // 查找HashMap中与diff1对应的次数，将次数累加到计数器中
            count += numCount.getOrDefault(diff2, 0); // 查找HashMap中与diff2对应的次数，将次数累加到计数器中
            numCount.put(num, numCount.getOrDefault(num, 0) + 1); // 更新HashMap，将当前元素的出现次数加一
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(countKDifference2(new int[]{1, 2, 2, 1}, 1));
    }
}
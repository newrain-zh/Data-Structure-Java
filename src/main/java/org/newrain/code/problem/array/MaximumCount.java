package org.newrain.code.problem.array;


/**
 * 题目：leetcode.2529 正整数和负整数的最大计数
 * 给你一个按 非递减顺序 排列的数组 nums ，返回正整数数目和负整数数目中的最大值。
 * 换句话讲，如果 nums 中正整数的数目是 pos ，而负整数的数目是 neg ，返回 pos 和 neg二者中的最大值。
 * 注意：0 既不是正整数也不是负整数。
 * 示例 1：
 * 输入：nums = [-2,-1,-1,1,2,3]
 * 输出：3
 * 解释：共有 3 个正整数和 3 个负整数。计数得到的最大值是 3 。
 */
public class MaximumCount {

    public static int maximumCount(int[] nums) {
        int pNumber = 0, zeroCount = 0, nNumber = 0;
        for (int num : nums) {
            if (num > 0) {
                pNumber++;
            } else if (num == 0) {
                zeroCount++;
            } else {
                nNumber++;
            }
        }
        return Math.max(nums.length - pNumber - zeroCount, nums.length - nNumber - zeroCount);
    }

    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
    }
}
package org.newrain.problems.problem.array;


/**
 * 题目：leetcode.2057 值相等的最小索引
 * 给你一个下标从 0 开始的整数数组 nums ，返回 nums 中满足 i mod 10 == nums[i] 的最小下标 i ；
 * 如果不存在这样的下标，返回 -1 。
 * x mod y 表示 x 除以 y 的 余数 。
 * 示例 1：
 * 输入：nums = [0,1,2]
 * 输出：0
 * 解释：
 * i=0: 0 mod 10 = 0 == nums[0].
 * i=1: 1 mod 10 = 1 == nums[1].
 * i=2: 2 mod 10 = 2 == nums[2].
 * 所有下标都满足 i mod 10 == nums[i] ，所以返回最小下标 0
 */
public class SmallestEqual {


    public static int smallestEqual(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == (i % 10)) {
                return i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(smallestEqual(new int[]{7, 8, 3, 5, 2, 6, 3, 1, 1, 4, 5, 4, 8, 7, 2, 0, 9, 9, 0, 5, 7, 1, 6}));
        System.out.println(21 % 10);
    }
}
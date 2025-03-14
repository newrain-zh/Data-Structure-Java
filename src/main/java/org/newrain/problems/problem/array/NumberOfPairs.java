package org.newrain.problems.problem.array;


import java.util.Arrays;

/**
 * 题目：leetcode.2341. 数组能形成多少数对
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 * <p>
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，
 * 其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 * <p>
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2,1,3,2,2]
 * 输出：[3,1]
 * 解释：
 * nums[0] 和 nums[3] 形成一个数对，并从 nums 中移除，nums = [3,2,3,2,2] 。
 * nums[0] 和 nums[2] 形成一个数对，并从 nums 中移除，nums = [2,2,2] 。
 * nums[0] 和 nums[1] 形成一个数对，并从 nums 中移除，nums = [2] 。
 * 无法形成更多数对。总共形成 3 个数对，nums 中剩下 1 个数字。
 * 示例
 */
public class NumberOfPairs {

    public static int[] numberOfPairs(int[] nums) {
        if (nums.length == 1) {
            return new int[]{0, 1};
        }
        //判断nums的len
        int[] dict = new int[101];
        for (int num : nums) {
            dict[num]++;
        }
        int ans = 0, len = 0;
        for (int j : dict) {
            if (j == 0) continue;
            if (j >= 2) {//说明成对出现
                if ((j & 1) == 0) {//为偶数
                    ans = ans + j / 2;
                } else {
                    ans = ((j - 1) / 2) + ans;
                    len++;
                }
            } else if (j == 1) len++;//只出现一次的
        }
        return new int[]{ans, len};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
//        以下未通过测试用例
//        System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 1})));//[1,0]
//        System.out.println(Arrays.toString(numberOfPairs(new int[]{1})));//[0,1]
        System.out.println(Arrays.toString(numberOfPairs(new int[]{1, 2, 3, 4, 5})));//[0,1]
    }
}
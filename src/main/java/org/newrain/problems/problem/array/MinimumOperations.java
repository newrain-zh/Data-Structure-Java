package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
// * 题目： leetcode.2357. 使数组中所有元素都等于零
 * 给你一个非负整数数组 nums 。在一步操作中，你必须：
 * 选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
 * nums 中的每个正整数都减去 x。
 * 返回使 nums 中所有元素都等于 0 需要的 最少 操作数。
 * 示例
 * 输入：nums = [1,5,0,3,5]
 * 输出：3
 * 解释：
 * 第一步操作：选出 x = 1 ，之后 nums = [0,4,0,2,4] 。
 * 第二步操作：选出 x = 2 ，之后 nums = [0,2,0,0,2] 。
 * 第三步操作：选出 x = 2 ，之后 nums = [0,0,0,0,0] 。
 */
public class MinimumOperations {

    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
//        System.out.println(minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println(minimumOperations(new int[]{1, 2, 5, 3}));

    }
}
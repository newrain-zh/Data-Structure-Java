package org.newrain.code.problem.base;

/**
 * @author NewRain
 * @description 最大连续1的个数
 * @link <a href="https://leetcode.cn/problems/max-consecutive-ones/">leetcode</a>
 * @link <a href="https://www.lintcode.com/problem/1212/">lintcode</a>
 */
public class FindMaxConsecutiveOnes {


    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            if (num == 1) {
                count = count + 1;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return Math.max(count, max);
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }
}

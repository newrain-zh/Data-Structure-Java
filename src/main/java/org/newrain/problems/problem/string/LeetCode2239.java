package org.newrain.problems.problem.string;


/**
 * 2239. 找到最接近 0 的数字
 * <a href="https://leetcode.cn/problems/find-closest-number-to-zero/description/">...</a>
 */
public class LeetCode2239 {


    public static int findClosestNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // 找到最小的正整数 和 最大的负整数
        int maxVal1 = Integer.MAX_VALUE;
        int maxVal2 = Integer.MIN_VALUE + 1; // 避免溢出 否则 abs 无法 计算
        for (int num : nums) {
            if (num >= 0) {
                maxVal1 = Math.min(maxVal1, num);
            } else {
                maxVal2 = Math.max(maxVal2, num);
            }
        }
        if (Math.abs(maxVal2) >= maxVal1) {
            return maxVal1;
        }
        return maxVal2;
    }

    public static void main(String[] args) {
      /*  System.out.println(findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
        System.out.println(findClosestNumber(new int[]{2, -1, 1}));*/

        System.out.println(findClosestNumber(new int[]{10000, 10000, 10000, 10000, 10000, 10000, 10000}));
    }
}
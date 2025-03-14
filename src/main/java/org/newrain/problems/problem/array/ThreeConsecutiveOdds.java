package org.newrain.problems.problem.array;


/**
 * 题目：leetcode.1550 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
 * 如果存在，请返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 */
public class ThreeConsecutiveOdds {

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int j : arr) {
            if ((j & 1) == 1) {// x&1 ==1 为奇数 x&1 == 0 为偶数
                count++;
                if (count == 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
    }
}
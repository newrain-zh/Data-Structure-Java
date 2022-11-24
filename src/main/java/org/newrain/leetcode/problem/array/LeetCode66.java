package org.newrain.leetcode.problem.array;

import java.util.Arrays;

/**
 * @author newRain
 * @description 加一
 * @complexity easy
 * @link <a href="https://leetcode.cn/problems/plus-one/">...</a>
 */
public class LeetCode66 {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {
        int[] its = plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(its));
    }
}

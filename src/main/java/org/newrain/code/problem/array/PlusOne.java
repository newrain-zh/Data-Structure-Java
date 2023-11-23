package org.newrain.code.problem.array;

import java.util.Arrays;

/**
 * @author NewRain
 * @description 加一
 * @complexity easy
 * @link <a href="https://leetcode.cn/problems/plus-one/">leetcode</a>
 * @link <a href="https://www.lintcode.com/problem/407">lintcode</a>
 * @tag 数组 array
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            //判断是否为加一10
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        //这里的情况为数组都为9的情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;

    }

    public static void main(String[] args) {
        int[] its = plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(its));
    }
}
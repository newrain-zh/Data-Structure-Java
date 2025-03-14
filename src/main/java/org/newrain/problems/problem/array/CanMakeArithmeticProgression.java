package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * 题目：判断能否形成等差数列
 */
public class CanMakeArithmeticProgression {

    public static boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) {
            return true;
        }
        Arrays.sort(arr);
        int diff = arr[0] - arr[1];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] - arr[i + 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[]{3, 5, 1})); //true
        System.out.println(canMakeArithmeticProgression(new int[]{1, 2, 4}));//false
    }
}
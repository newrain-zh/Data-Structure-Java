package org.newrain.leetcode.problem.number;

public class LeetCode263 {


    public boolean isUgly(int n) {
        if (n <= 0) {
            return true;
        }
        int[] arr = new int[]{2, 3, 5};

        for (int a : arr) {
            while (n % a == 0) {
                n /= a;
            }
        }
        return n == 1;

    }

    public static void main(String[] args) {

    }
}

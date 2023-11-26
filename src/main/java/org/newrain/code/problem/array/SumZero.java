package org.newrain.code.problem.array;


/**
 * 题目：1304. 和为零的 N 个不同整数
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 */
public class SumZero {


    public int[] sumZero(int n) {
        if (n == 1) {
            return new int[]{0};
        }
        if (n == 2) {
            return new int[]{-1, 1};
        }
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            ans[i] = i;
            sum -= i;
        }
        ans[n - 1] = sum;
        return ans;
    }
}
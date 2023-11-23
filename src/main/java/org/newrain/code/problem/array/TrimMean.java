package org.newrain.code.problem.array;


import java.util.Arrays;

/**
 * 题目：删除某些元素后的数组均值
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果。
 */
public class TrimMean {


    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = (int) (arr.length * 0.05);
        int sum = 0;
        for (int i = n; i < arr.length - n; i++) {
            sum += arr[i];
        }
        return (double) sum / (arr.length * 0.9);

    }
}
package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目：leetcode.1588 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * 示例 1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * <p>
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 */
public class SumOddLengthSubarrays {

    /**
     * 该处代码只是为了演示题目中枚举的数组
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j < arr.length - 2) { //这里循环要做的是列出当前数组的所有可能
                j += 2;//这里要计算i,j
                List<Integer> subList = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    subList.add(arr[k]);
                }
                list.add(subList);
            }
        }
        return sum;

    }

    /**
     * 枚举方法
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int j = i;
            //终止条件 arr.length - 2 遍历到倒数第二位时，是无法构成奇数长度数组的
            while (j < arr.length - 2) { //这里循环要做的是列出当前位置能构建所有奇数长度数组的可能
                j += 2;//这里要计算i,j
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;

    }


    /**
     * 以数学的思路解决该问题
     *
     * @param arr
     * @return
     */
    public static int sumOddLengthSubarraysByMath(int[] arr) {
        int sum = 0;
        int n = arr.length;

        // 遍历数组中的每个元素
        for (int i = 0; i < n; i++) {
            // 计算左边和右边的元素个数
            int leftCount = i + 1;
            int rightCount = n - i;

            // 计算左边和右边奇数长度子数组的个数和偶数长度子数组的个数
            int leftOdd = (leftCount + 1) / 2;
            int rightOdd = (rightCount + 1) / 2;

            int leftEven = leftCount / 2;
            int rightEven = rightCount / 2;
            // 计算以当前元素为中心的所有奇数长度子数组的和，并将其累加到最终的结果中
            sum += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
        }
        return sum;
    }

    public static int getSubArraySum(int[] arr, int start, int end) {
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sum += arr[i];
            stringBuilder.append(arr[i]).append(",");
        }
        System.out.println(stringBuilder);
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays2(new int[]{1, 4, 2, 5, 3}));
    }
}
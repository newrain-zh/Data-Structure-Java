package org.newrain.problems.problem.array;


import java.util.Arrays;

/**
 * leetcode.2164 对奇偶下标分别排序
 * 给你一个下标从 0 开始的整数数组 nums 。根据下述规则重排 nums 中的值：
 * <p>
 * 1. 按 非递增 顺序排列 nums 奇数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对奇数下标的值排序后变为 [4,3,2,1] 。
 * 奇数下标 1 和 3 的值按照非递增顺序重排。
 * <p>
 * 2.按 非递减 顺序排列 nums 偶数下标 上的所有值。
 * 举个例子，如果排序前 nums = [4,1,2,3] ，对偶数下标的值排序后变为 [2,1,4,3] 。
 * 偶数下标 0 和 2 的值按照非递减顺序重排。
 * 返回重排 nums 的值之后形成的数组。
 */
public class SortEvenOdd {

    public static int[] sortEvenOdd(int[] nums) {
        int length = nums.length;//先判断数组长度
        int[] evenArr = new int[length / 2];//偶数下标
        int[] oddArr = new int[(length + 1) / 2];//奇数下标
        int oP = 0, eP = 0;
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 0) { //
                evenArr[eP] = nums[i];
                eP++;
            } else {
                oddArr[oP] = nums[i];
                oP++;
            }
        }
        Arrays.sort(evenArr);//偶数下标递增
        Arrays.sort(oddArr);//奇数下标递
        int[] oddArrNew = new int[oddArr.length];
        int start = 0;
        for (int i = oddArrNew.length - 1; i >= 0; i--) {
            oddArrNew[start] = oddArr[i];
            start++;
        }
        //重置位置计数
        int[] ans = new int[length];
        oP = 0;
        eP = 0;
        for (int i = 0; i < length; i++) {
            if ((i & 1) == 0) {
                ans[i] = evenArr[eP];
                eP++;
            } else {
                ans[i] = oddArrNew[oP];
                oP++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortEvenOdd(new int[]{4, 1, 2, 3})));//2,3,4,1
        System.out.println(Arrays.toString(sortEvenOdd(new int[]{5, 39, 33, 5, 12, 27, 20, 45, 14, 25, 32, 33, 30, 30, 9, 14, 44, 15, 21})));//2,3,4,1
    }
}
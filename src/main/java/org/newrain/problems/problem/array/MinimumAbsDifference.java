package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode.1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * 每对元素对 [a,b] 如下：
 * a , b 均为数组 arr 中的元素
 * a < b
 * b - a 等于 arr 中任意两个元素的最小绝对差
 */
public class MinimumAbsDifference {

    /**
     * 求出最小的绝对值的差值然后遍历，就可以
     * @param arr
     * @return
     */
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int abs = Math.abs(arr[i + 1] - arr[i]);
            if (abs <= diff) {
                diff = abs;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == diff) {
                List<Integer> subList = new ArrayList<>(2);
                subList.add(arr[i]);
                subList.add(arr[i + 1]);
                ans.add(subList);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4, 2, 1, 3}));
        System.out.println(minimumAbsDifference(new int[]{1, 3, 6, 10, 15}));
        System.out.println(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
//        System.out.println(11 - (-20));
//        System.out.println((-20) - 11);
        System.out.println(minimumAbsDifference(new int[]{40, 11, 26, 27, -20}));//[26,27]
    }
}
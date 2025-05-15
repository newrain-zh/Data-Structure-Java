package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1539. 第 k 个缺失的正整数
 */
public class LeetCode1539 {

    /**
     * 模拟解法
     * TODO 待优化 模拟解法速度太慢
     */
    public static int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int next = 1;
        for (int j : arr) {
            if (j != next) { // 说明不匹配
                int diff = j - next;
                int curr = j - diff;
                while (curr < j) {
                    list.add(curr);
                    curr++;
                }
                if (list.size() >= k) {
                    return list.get(k - 1);
                }
                next = j + 1;
            } else {
                next++;
            }
        }
        int num = k - list.size();
        return next + num - 1;
    }


    public static int findKthPositive1(int[] arr, int k) {
        int next = 0;
        int i = 0;
        while (k > 0) {
            next++;
            if (i < arr.length && next == arr[i]) {
                i++;
            } else {
                k--;
            }
        }
        return next;
    }

    /**
     * 如果数组中没有小于k的数，那么第k个缺失的数字就是k
     */
    public static int findKthPositive2(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }
        return k;
    }

    public int findKthPositive4(int[] arr, int k) {
        int missCount = 0, lastMiss = 0, index = 0, num = 1;

        while (missCount < k) {
            if (index < arr.length && arr[index] == num) {
                index++; // 数组中有这个数，跳过
            } else {
                missCount++; // 记录缺失的数字
                lastMiss = num; // 记录当前缺失的数
            }
            num++; // 继续下一个数
        }
        return lastMiss;
    }


    public static void main(String[] args) {
        System.out.println(findKthPositive2(new int[]{2, 3, 4, 7, 11}, 5)); // 9
        System.out.println(findKthPositive2(new int[]{1, 2, 3, 4}, 2)); // 6
        System.out.println(findKthPositive2(new int[]{2}, 1)); // 1
        System.out.println(findKthPositive2(new int[]{5, 6, 7, 8, 9}, 9)); // 14
    }
}
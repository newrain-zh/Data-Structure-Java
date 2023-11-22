package org.newrain.code.problem.array;

/**
 * 题目： 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 */
public class FindLucky {

    public static int findLucky(int[] arr) {
        int max = 0;//获取最大值 精确构建字段数组的长度
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int[] dict = new int[max + 1];
        for (int currVale : arr) {
            dict[currVale] = dict[currVale] + 1;
        }
        for (int i = dict.length - 1; i >= 1; i--) {
            if (i == dict[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
//        System.out.println(findLucky(new int[]{2, 2, 2, 3, 3}));

    }
}
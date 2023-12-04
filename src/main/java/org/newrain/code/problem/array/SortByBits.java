package org.newrain.code.problem.array;


import java.util.*;

/**
 * 题目： leetcode.1356 根据数字二进制下 1 的数目排序
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组。
 * 示例 1：
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 */
public class SortByBits {

    /**
     * 暴力枚举
     *
     * @param arr
     * @return
     */
    public static int[] sortByBits(int[] arr) {
        Map<Integer, Integer> bitmapMap = new HashMap<>(arr.length);
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            bitmapMap.put(j, bitCount(j));
            list.add(j);
        }
        list.sort((x, y) -> {
            if (bitmapMap.get(x).compareTo(bitmapMap.get(y)) != 0) {
                return bitmapMap.get(x) - bitmapMap.get(y);
            } else {
                return x - y;
            }
        });
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static int bitCount(int x) {
        int cnt = 0;
        while (x > 0) {
            x = x & (x - 1);
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int a = 10 ^ 4;
        System.out.println(a);
        System.out.println(Arrays.toString(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));//0,1,2,4,8,3,5,6,7
        System.out.println(Arrays.toString(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));//0,1,2,4,8,3,5,6,7
    }


}
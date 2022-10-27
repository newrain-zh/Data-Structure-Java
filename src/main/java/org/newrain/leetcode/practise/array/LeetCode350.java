package org.newrain.leetcode.practise.array;

import java.util.*;

/**
 * 给你两个整数数组 nums1 和 nums2 ，
 * 请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
 * 可以不考虑输出结果的顺序。
 *
 * @author newrain
 */
public class LeetCode350 {

    /**
     * 解法1 利用集合
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        List<Integer> integers = new ArrayList<>(nums1.length);
        for (int k : nums1) {
            integers.add(k);
        }
        List<Integer> list = new ArrayList<>(nums1.length);
        for (int j : nums2) {
            if (integers.contains(j)) {
                list.add(j);
                integers.set(integers.indexOf(j), null);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}

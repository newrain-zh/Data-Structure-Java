package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode.88 合并两个有序数组
 *
 * <a href="https://leetcode.cn/problems/merge-sorted-array/description/">...</a>
 *
 * @author newrain
 */
public class Merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        List<Integer> integers = new ArrayList<>(Math.max(m, n));
        for (int i = 0; i < m; i++) {
            integers.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            integers.add(nums2[i]);
        }
        int[] ints = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            ints[i] = integers.get(i);
        }
        Arrays.sort(ints);
        System.arraycopy(ints, 0, nums1, 0, nums1.length);
    }


}
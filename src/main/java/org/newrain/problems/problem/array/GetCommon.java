package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：leetcode.2540. 最小公共值
 * 给你两个整数数组 nums1 和 nums2 ，它们已经按非降序排序，
 * 请你返回两个数组的 最小公共整数 。如果两个数组 nums1 和 nums2 没有公共整数，请你返回 -1 。
 * 如果一个整数在两个数组中都 至少出现一次 ，那么这个整数是数组 nums1 和 nums2 公共 的。
 */
public class GetCommon {

    /**
     * TODO 还有最优解
     * @param nums1
     * @param nums2
     * @return
     */
    public int getCommon(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                return i;
            }
        }
        return -1;
    }


}
package org.newrain.code.problem.array;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你三个整数数组 nums1、nums2 和 nums3 ，
 * 请你构造并返回一个 元素各不相同的 数组，且由 至少 在 两个 数组中出现的所有值组成。
 * 数组中的元素可以按 任意 顺序排列。
 */
public class TwoOutOfThree {

    public static void main(String[] args) {

    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> ans1 = new HashSet<>(); // 1,2的交集
        getCommonInt(ans1, nums1, nums2);
        getCommonInt(ans1, nums1, nums3);
        getCommonInt(ans1, nums2, nums3);
        return new ArrayList<>(ans1);
    }

    public static void getCommonInt(Set<Integer> ans, int[] nums1, int[] nums2) {
        Set<Integer> currCommon = new HashSet<>();
        for (int n : nums1) {
            currCommon.add(n);
        }
        for (int i : nums2) {
            if (currCommon.contains(i)) {
                ans.add(i);
            }
        }
    }
}
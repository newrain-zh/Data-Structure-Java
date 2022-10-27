package org.newrain.leetcode.practise.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> dict = new HashSet<>(nums1.length);
        for (int j : nums1) {
            dict.add(j);
        }
        List<Integer> result = new ArrayList<>(dict.size());
        for (int j : nums2) {
            if (dict.contains(j) && !result.contains(j)) {
                result.add(j);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}

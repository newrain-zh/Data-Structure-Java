package org.newrain.leetcode.practise.number;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode414 {

    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        Set<Integer> integerSet = new HashSet<>(nums.length);
        for (int v : nums) {
            integerSet.add(v);
        }
        List<Integer> collect = integerSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if (collect.size() == 1) {
            return collect.get(0);
        }
        if (collect.size() == 2) {
            return Math.max(collect.get(0), collect.get(1));
        }
        return collect.get(2);

    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));

    }
}

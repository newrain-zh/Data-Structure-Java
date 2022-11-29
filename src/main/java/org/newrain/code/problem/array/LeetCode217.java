package org.newrain.code.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；
 * 如果数组中每个元素互不相同，返回 false 。
 *
 * @author newrain
 */
public class LeetCode217 {


    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int v : nums) {
            if (set.contains(v)) {
                return true;
            } else {
                set.add(v);
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        for (int v : nums) {
            set.add(v);
        }
        return set.size() != nums.length;
    }
}

package org.newrain.leetcode.problem.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCode136 {


    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}

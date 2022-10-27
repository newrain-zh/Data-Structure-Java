package org.newrain.leetcode.practise.array;

import java.util.HashMap;
import java.util.Map;

public class LeetCode137 {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    public int singleNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int serach = nums[i];
            int l = 0;
            int r = nums.length;
            int count = 0;
            while (l < r) {
                if (nums[l + 1] == serach) {
                    count++;
                }
                l++;
            }
            if (count == 1) {
                return nums[i];
            }
        }
        return -1;
    }
}

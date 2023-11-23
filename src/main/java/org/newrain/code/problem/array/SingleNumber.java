package org.newrain.code.problem.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

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
        for (int search : nums) {
            int l = 0;
            int r = nums.length;
            int count = 0;
            while (l < r) {
                if (nums[l + 1] == search) {
                    count++;
                }
                l++;
            }
            if (count == 1) {
                return search;
            }
        }
        return -1;
    }

    /**
     * @param a: An integer array
     * @return An integer
     */
    public int singleNumber2(int[] a) {
        int single = 0;
        for (int num : a) {
            single ^= num;
        }
        return single;
    }
}
package org.newrain.problems.problem.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode137. 只出现一次的数字
 */
public class LeetCode137 {


    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int num = entry.getKey();
            if (entry.getValue() == 1) {
                ans = num;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
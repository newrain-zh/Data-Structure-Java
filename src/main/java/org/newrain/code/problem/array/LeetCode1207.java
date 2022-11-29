package org.newrain.code.problem.array;

import java.util.*;

/**
 * @author NewRain
 * @description 独一无二的出现次数
 * @link <a href="https://leetcode.cn/problems/unique-number-of-occurrences/"></a>
 */
public class LeetCode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int v : arr) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.size());
        for (Integer count : map.values()) {
            if (set.contains(count)) {
                return false;
            } else {
                set.add(count);
            }
        }
        return true;
    }
}

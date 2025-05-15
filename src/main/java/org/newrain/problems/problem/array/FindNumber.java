package org.newrain.problems.problem.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhiqin.zhang
 * @description 数组中出现次数最多的值
 * @link <a href="https://www.lintcode.com/problem/1910/">lintcode</a>
 */
public class FindNumber {


    /**
     * @param array: An array.
     * @return An int value
     */
    public int findNumber(int[] array) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        int max = 0;
        for (int v : array) {
            int val = map.getOrDefault(v, 0) + 1;
            map.put(v, val);
            max = Math.max(max, val);
        }
        Set<Integer> integers = map.keySet();
        int min = Integer.MAX_VALUE;
        for (int key : integers) {
            if (map.get(key) == max) {
                min = Math.min(key, min);
            }
        }

        return min;
    }
}
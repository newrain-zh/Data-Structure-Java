package org.newrain.problems.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NewRain
 * @description 在长度 2N 的数组中找出重复 N 次的元素
 * @link <a href="https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/"></a>
 * @tag array
 */
public class RepeatedNTimes {

    public int repeatedNTimes(int[] nums) {
        int cnt = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int n : nums) {
            Integer orDefault = map.getOrDefault(n, 0);
            map.put(n, orDefault + 1);
            if (map.get(n) == cnt) {
                return n;
            }
        }
        return -1;
    }
}
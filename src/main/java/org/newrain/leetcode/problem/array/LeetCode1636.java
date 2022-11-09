package org.newrain.leetcode.problem.array;

import org.junit.Assert;

import java.util.*;

import static org.junit.Assert.*;


/**
 * @author zhiqin.zhang
 */
public class LeetCode1636 {

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        List<Integer> numsList = new ArrayList<>(nums.length);
        for (int v : nums) {
            numsList.add(v);
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        numsList.sort((a, b) -> {
            int cntA = map.get(a), cntB = map.get(b);
            return cntA != cntB ? cntA - cntB : b - a;
        });
        return numsList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1, 1, 2, 2, 2, 3})));
        System.out.println(Arrays.toString(frequencySort(new int[]{2, 3, 1, 3, 2})));
    }
}

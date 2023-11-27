package org.newrain.code.problem.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目：leetcode.2404 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * 示例 1：
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 */
public class MostFrequentEven {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = Integer.MIN_VALUE; //
        int uniqueEven = 0;//
        for (int num : nums) {
            if ((num & 1) == 0) {
                uniqueEven = num;
                int count = map.getOrDefault(num, 0) + 1;
                maxCount = Math.max(maxCount, count);
                map.put(num, count);
            }
        }
        if (map.isEmpty()) { //表示没有负数
            return -1;
        }
        if (map.size() == 1) {//如果只有唯一的偶数直接返回
            return uniqueEven;
        }

        //判断等于最大出现次数的偶数有哪些
        List<Integer> ansList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) {
                ansList.add(key);
            }
        }
        if (ansList.size() == 1) {
            return ansList.get(0);
        }
        int ans = ansList.get(0);
        for (int i = 1; i < ansList.size(); i++) {
            ans = Math.min(ans, ansList.get(i));
        }
        return ans;


    }

}
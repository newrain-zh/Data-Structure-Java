package org.newrain.leetcode.practise.array;

import java.util.ArrayList;
import java.util.List;

public class LeetCode905 {

    public int[] sortArrayByParity(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        //奇数数组
        List<Integer> list1 = new ArrayList<>();
        //偶数数组
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        if (list1.isEmpty() || list2.isEmpty()) {
            return nums;
        }
        list2.addAll(list1);
        int[] result = new int[nums.length];
        for (int i = 0; i < list2.size(); i++) {
            result[i] = list2.get(i);
        }
        return result;
    }
}

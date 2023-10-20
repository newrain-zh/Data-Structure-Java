package org.newrain.code.problem.array;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {


    /**
     * @param nums: An integer array
     * @return: The largest and only once occurring integer in the array
     */
    public static int largestUniqueNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int val : nums) {
            if (count.containsKey(val)) {
                count.put(val, count.getOrDefault(val, 0) + 1);
            } else {
                count.put(val, 1);
            }
        }
        int largestUniqueNumber = Integer.MIN_VALUE;
        int number = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            //只出现一次
            if (entry.getValue() == 1) {
                largestUniqueNumber = Math.max(entry.getKey(), largestUniqueNumber);
            } else {
                number++;
            }
        }
        if (number == count.size()){
            return -1;
        }
        return largestUniqueNumber;
    }

    public static void main(String[] args) {
        System.out.println(largestUniqueNumber(new int[]{3, 5, 1, 7, 9, 1, 9, 9}));

    }
}
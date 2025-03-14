package org.newrain.problems.problem.array;

import java.util.Comparator;
import java.util.List;

/**
 * lint code 297题
 */
public class MaxNum {


    /**
     * @param nums: the list of numbers
     * @return: return the maximum number.
     */
    public int maxNum(List<Integer> nums) {
        int maxNum = Integer.MIN_VALUE;
        for (Integer num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        return maxNum;
    }

    public int maxNum1(List<Integer> nums) {
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);
        return nums.stream().max(comparator).orElse(0);
    }
}
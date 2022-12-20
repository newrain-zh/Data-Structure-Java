package org.newrain.code.problem.array;

import java.util.Collections;
import java.util.List;

/**
 * @author NewRain
 * @description 主元素
 * @link <a href="https://www.lintcode.com/problem/46">lintcode</a>
 * @complexity easy
 */
public class MajorityNumber {

    /**
     * @param nums: a list of integers
     * @return find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        Collections.sort(nums);
        return nums.get(nums.size() / 2);
    }
}
package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author NewRain
 * @description 找到所有数组中消失的数字
 * @link <a href="https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/"></a>
 */
public class FindDisappearedNumbersI {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        Set<Integer> e = new HashSet<>(length);
        for (int num : nums) {
            e.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if (!e.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers(new int[]{1, 1}));
    }
}
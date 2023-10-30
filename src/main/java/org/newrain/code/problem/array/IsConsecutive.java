package org.newrain.code.problem.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsConsecutive {


    /**
     * @param nums: An integer array.
     * @return: Whether the array is consecutive.
     */
    public static boolean isConsecutive1(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        int length = nums.length;
        if (nums[length - 1] - nums[0] != length - 1) return false;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) return false;
        }
        return true;
    }

    /**
     * 范围 [x, x + n - 1]
     *
     * @param nums
     * @return
     */
    public static boolean isConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>(nums.length);
        //min、max确认数据范围
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            set.add(n);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        //不相等说明有重复数据
        if (nums.length != set.size()) {
            return false;
        }
        for (int i = min; i < max; i++) {
            //循环查找最小值递增的数据 如果不包含最小值的递增值说明不是连贯数组
            if (!set.contains(++i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isConsecutive2(new int[]{1, 3}));
        System.out.println(isConsecutive2(new int[]{1, 3, 4, 2}));
        System.out.println(isConsecutive2(new int[]{1, 2, 2, 4}));
    }
}
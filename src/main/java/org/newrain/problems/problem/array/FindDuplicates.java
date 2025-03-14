package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.442 数组中的重复元素
 *
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，
 * <p>
 * 且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 */
public class FindDuplicates {

    /**
     * 根据题意将数组下标的值-1 获取当前值在数组中的位置
     * <p>
     * 并将该位置的值变成负数
     * <p>
     * index = nums[i] - 1
     * <p>
     * 如果遍历过程中发现下标是负数 则说明当前值在之前出现过一次,直接加入ans列表
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>(0);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;//获取下标
            if (nums[index] < 0) { //表示曾经出现过该数组下标减一的数字
                ans.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index]; //直接将该下标的数字变成负数
            }
        }
        return ans;
    }

    /**
     * ➕n法  n为数组长度
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>(0);
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1) % n; //获取数组下标
            nums[index] += n;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) { //出现2次的值 肯定是大于数组长度2n
                ans.add(i + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
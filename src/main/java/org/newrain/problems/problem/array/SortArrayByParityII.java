package org.newrain.problems.problem.array;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 按奇偶排序数组 II
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] nums) {
        Deque<Integer> evenNumber = new LinkedList<>();
        Deque<Integer> oddNumber = new LinkedList<>();
        for (int x : nums) {
            if ((x & 1) == 0) {//偶数
                evenNumber.offer(x);
            } else {
                oddNumber.offer(x);
            }
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                ans[i] = evenNumber.remove();
            } else {
                ans[i] = oddNumber.remove();
            }
        }
        return ans;
    }
}
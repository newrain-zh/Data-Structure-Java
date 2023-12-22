package org.newrain.code.problem.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode.2956 找到两个数组中的公共元素
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。
 * <p>
 * 请你计算以下两个数值：
 * <p>
 * 统计 0 <= i < n 中的下标 i ，满足 nums1[i] 在 nums2 中 至少 出现了一次。
 * <p>
 * 统计 0 <= i < m 中的下标 i ，满足 nums2[i] 在 nums1 中 至少 出现了一次。
 * <p>
 * 请你返回一个长度为 2 的整数数组 answer ，按顺序 分别为以上两个数值。
 */
public class FindIntersectionValues {


    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        //获取num1的
        int[] ans = new int[2];
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums2) {
            set2.add(j);
        }
        ans[0] = findValue(nums1, set2);

        Set<Integer> set1 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        ans[1] = findValue(nums2, set1);
        return ans;
    }

    public static int findValue(int[] nums, Set<Integer> dict) {
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (dict.contains(nums[i])) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findIntersectionValues(new int[]{4, 3, 2, 3, 1}, new int[]{2, 2, 5, 2, 3, 6})));
    }
}
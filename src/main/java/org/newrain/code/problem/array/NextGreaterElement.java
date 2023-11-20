package org.newrain.code.problem.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
public class NextGreaterElement {


    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> dictMap = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            dictMap.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            if (!dictMap.containsKey(nums1[i])) {
                continue;
            }
            if (dictMap.get(nums1[i]) == nums2.length - 1) {//如果等于num1[i]在num2的数组的最后一位 说明不会存在比num[i]下一位更大的数
                continue;
            }
            for (int j = dictMap.get(nums1[i]); j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    ans[i] = nums2[j]; //找到下一位更大的数直接跳出此处循环
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));//[-1,3,-1]
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));//[3,-1]
    }
}
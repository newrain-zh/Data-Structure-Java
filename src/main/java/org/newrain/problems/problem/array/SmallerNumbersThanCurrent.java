package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 */
public class SmallerNumbersThanCurrent {

    /**
     * 暴力枚举
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < curr && j != i) {
                    count++;
                }
            }
            tmpList.add(count);
        }
        int[] ans = new int[tmpList.size()];
        for (int i = 0; i < tmpList.size(); i++) {
            ans[i] = tmpList.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }
}
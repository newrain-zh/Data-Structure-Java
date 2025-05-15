package org.newrain.problems.problem.array;

/**
 * 题目：leetcode.2176. 统计数组中相等且可以被整除的数对
 * 输入：nums = [3,1,2,2,2,1,3], k = 2
 * 输出：4
 * 解释：
 * 总共有 4 对数符合所有要求：
 * - nums[0] == nums[6] 且 0 * 6 == 0 ，能被 2 整除。
 * - nums[2] == nums[3] 且 2 * 3 == 6 ，能被 2 整除。
 * - nums[2] == nums[4] 且 2 * 4 == 8 ，能被 2 整除。
 * - nums[3] == nums[4] 且 3 * 4 == 12 ，能被 2 整除。
 */
public class CountPairsI {


    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if ((i * j) % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
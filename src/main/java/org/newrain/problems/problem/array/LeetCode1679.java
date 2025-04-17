package org.newrain.problems.problem.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1679. K 和数对的最大数目
 */
public class LeetCode1679 {


    /**
     * 其实就是在数组找到 x+y = k 中 x和 y一共可以有多少队的问题
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> set = new HashMap<>(nums.length);
        int                   ans = 0;
        for (int num : nums) {
            int diff = k - num;
            if (set.getOrDefault(diff, 0) > 0) {
                set.put(diff, set.get(diff) - 1);
                ans++;
            } else {
                set.put(num, set.getOrDefault(num, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6)); // 1
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5)); // 2

    }


}
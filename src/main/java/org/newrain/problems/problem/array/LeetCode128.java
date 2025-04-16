package org.newrain.problems.problem.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 */
public class LeetCode128 {


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {  // 去重
            if (!set.contains(num - 1)) { // 判断当前元素是否是起点
                int curr    = num;
                int currMax = 1;
                while (set.contains(curr + 1)) {
                    currMax++;
                    curr++;
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode128 leetCode128 = new LeetCode128();
//        System.out.println(leetCode128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(leetCode128.longestConsecutive(new int[]{1, 0, -1}));
        System.out.println(leetCode128.longestConsecutive(new int[]{0, 0}));
    }
}
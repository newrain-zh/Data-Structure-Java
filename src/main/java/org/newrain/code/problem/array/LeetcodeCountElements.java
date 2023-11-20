package org.newrain.code.problem.array;

/**
 * 元素计数
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 * <p>
 * 这里翻译下 该题目就是统计除去最大数和最小数的数组的中的值的个数
 */
public class LeetcodeCountElements {

    public static int countElements(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int ans = 0;
        for (int num : nums) {
            if (num < max && num > min) {
                ans++;
            }
        }
        return ans;
    }
}
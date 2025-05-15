package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode.228 汇总区间
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * <p>
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @link <a href="https://leetcode.cn/problems/summary-ranges/description/">...</a>
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = 0;//左指针
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length || nums[i + 1] != nums[i] + 1) {//判断是否为自增
                if (l == i) {
                    ans.add(String.valueOf(nums[l]));
                } else {
                    ans.add(nums[l] + "->" + nums[i]);
                }
                //如果相邻元素之间的差值为1，继续遍历
                l = i + 1; //移动指针
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
}
package org.newrain.problems.problem.array;

/**
 * leetcode.724 寻找数组中心的下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 */
public class PivotIndex {

    /**
     * 中心的下标左右两把的值相等 意味着左边的值 * 2 = sum
     * 只要sum - 左边的值 = 左边的值 就意味着已经找到中心节点
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int sum = 0;//集合的所有值相加
        for (int num : nums) {
            sum += num;
        }
        int midSum = 0;//中心下标左边的值
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (midSum == sum) {
                return i;
            }
            midSum = midSum + nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex(new int[]{2, 1, -1}));
    }
}
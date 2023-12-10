package org.newrain.code.problem.array;

/**
 * leetcode.1909 删除一个元素使数组严格递增
 * 给你一个下标从 0 开始的整数数组 nums ，
 * 如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。
 * 如果数组本身已经是严格递增的，请你也返回 true 。
 * 数组 nums 是 严格递增 的定义为：
 * 对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
 */
public class CanBeIncreasing {

    public static boolean canBeIncreasing(int[] nums) {
        int cnt = 0; //判断不是递增的现象出现的次数
        int pre = nums[0];//标准值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {//
                pre = nums[i];
            } else {//这里判断不是递增
                cnt++;
                //更换标准值
                // i > 1 直接忽略数组长度为3的情况
                // nums[i] <= nums[i - 2] 当前值肯定小于 num[i-1]的值
                // 这里是为了选择哪个做为标准值进行下一轮的比较，
                // 如果当前值小于num[i-2] 就以num[i-1]的值做为标准 看后续的遍历中
                // 是否比num[i-1]的值还大 比该值大 说明是递增 比他小说明又出现不是递增的情况
                if (i > 1 && nums[i] <= nums[i - 2]) {
                    pre = nums[i - 1];
                    continue;
                }
                pre = nums[i];
                if (cnt > 2) {
                    return false;
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(canBeIncreasing(new int[]{1, 2, 10, 5, 7}));//true
        System.out.println(canBeIncreasing(new int[]{1, 2, 3}));//true
        System.out.println(canBeIncreasing(new int[]{1, 1, 1}));//false
        System.out.println(canBeIncreasing(new int[]{2, 3, 1, 2}));//false
    }

}
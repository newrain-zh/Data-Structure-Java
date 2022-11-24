package org.newrain.leetcode.problem.search;

/**
 * @author newRain
 * @description 二分查找
 * @link <a href="https://leetcode.cn/problems/binary-search/">...</a>
 * @tag 查询
 * @complexity easy
 */
public class LeetCode704 {

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
//            mid = (low + high) / 2;
            //此处 是为了避免数组的元素过大，
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //说明数组在左侧
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}

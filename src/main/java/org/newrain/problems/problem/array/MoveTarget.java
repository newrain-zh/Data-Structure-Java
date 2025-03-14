package org.newrain.problems.problem.array;

/**
 * @author NewRain
 * @description 目标移动
 * @link <a href="https://www.lintcode.com/problem/1886">lintcode</a>
 */
public class MoveTarget {
    /**
     * @param nums:   a list of integer
     * @param target: an integer
     */
    public static void moveTarget(int[] nums, int target) {
        if (nums.length == 0) {
            return;
        }
        //从后向前遍历 只要不等于target的值 就向后移
        int right = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != target) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        moveTarget(new int[]{5, 1, 6, 1}, 1);
    }

}
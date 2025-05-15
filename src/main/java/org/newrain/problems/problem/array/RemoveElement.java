package org.newrain.problems.problem.array;

import java.util.Arrays;

public class RemoveElement {

    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public static int removeElement(int[] nums, int elem) {
        int n    = nums.length;
        int left = 0; //记录不等于elem的值的数量和记录上一个不等于elem的数组位置
        for (int right = 0; right < n; right++) {
            if (nums[right] != elem) {
                nums[left] = nums[right];
                left++;
            }
            System.out.println(Arrays.toString(nums));
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 4, 4, 0, 0, 2, 4, 4, 1}, 4));

    }
}
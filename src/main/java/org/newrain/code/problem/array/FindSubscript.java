package org.newrain.code.problem.array;

/**
 * 寻找下标
 */
public class FindSubscript {

    /**
     * @param nums: An integer array
     * @return: The minimum subscript
     */
    public int findSubscript(int[] nums) {
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == i){
                return i;
            }
        }
        return -1;
    }
}
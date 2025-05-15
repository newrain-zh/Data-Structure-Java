package org.newrain.problems.problem.array;

public class IsMajorityElement {

    /**
     * @param nums:   An integer array
     * @param target: An integer
     * @return: Is it a majority element
     */
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) count++;
        }
        //如果是主元素应该等于target的元素个数应该大于数组长度的2分之一
        return count > nums.length / 2;
    }
}
 package org.newrain.problems.problem.array;

 import java.util.List;

public class FindDisappearedNumbers {

    /**
     * @param nums: a list of integers
     * @return: return a list of integers
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            nums[i] = -Math.abs(index);
        }
        return null;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }


}
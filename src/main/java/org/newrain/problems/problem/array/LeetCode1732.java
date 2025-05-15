package org.newrain.problems.problem.array;

/**
 * LeetCode.1732 找到最高海拔
 */
public class LeetCode1732 {

    public static int largestAltitude(int[] gain) {
        int prev = 0, max = 0;
        for (int j : gain) {
            prev += j;
            if (prev > max) {
                max = prev;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));
//        System.out.println(1 + (-5));
        // -5,1,5,0,-7
        // -5,-4,1,1,-6

    }

}
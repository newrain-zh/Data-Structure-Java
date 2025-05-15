package org.newrain.problems.problem.array;


/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/jump-game/">...</a>
 */
public class LeetCode55 {

    /**
     * 数组下标      [ 0, 1 , 2 , 3, 4 ]
     * 原始数组      [ 3, 2 , 1 , 0, 4 ]
     * 能跳的最远位置 [ 3, 3 , 3 , 3, 8 ]
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int maxJump = 0; //能达到的最远位置
        // 遍历数组，记录每个下标能达到的最远位置
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > maxJump) { // i > maxJump 表示当前位置不可达
                return false;
            }
            // 如果当前位置 i <= maxJump 表示当前位置是可达的
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= length - 1) {
                return true;
            }
        }
        return maxJump >= length - 1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false
    }


}
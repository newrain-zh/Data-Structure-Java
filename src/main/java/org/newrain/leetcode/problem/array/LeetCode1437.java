package org.newrain.leetcode.problem.array;

/**
 * @author newRain
 * @description 是否所有 1 都至少相隔 k 个元素
 * @tag array
 */
public class LeetCode1437 {

    /**
     * 利用空间记录位置解题
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean kLengthApart(int[] nums, int k) {
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            }
        }
        int[] arr = new int[cnt];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                arr[--cnt] = i;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] - arr[i + 1]) < k + 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 索引解题
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean kLengthApart2(int[] nums, int k) {
        //1数字的位置索引
        int oneNumberIndex = -100000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - oneNumberIndex < k + 1) {
                    return false;
                }//更新1位置索引 保证变量为上一次出现1的位置
                oneNumberIndex = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(kLengthApart2(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(kLengthApart2(new int[]{1, 1, 1, 1, 1, 1, 1}, 0));
        System.out.println(kLengthApart2(new int[]{0, 1, 0, 1}, 0));
        System.out.println(kLengthApart2(new int[]{1, 0, 0, 1, 0, 1}, 2));
    }
}

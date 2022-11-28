package org.newrain.leetcode.problem.number;

/**
 * @author newrain
 * @description 位1的个数
 * @link <a href="https://leetcode.cn/problems/number-of-1-bits/">leetcode</a>
 * @位晕眩
 */
public class LeetCode191 {


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            //相当于减一操作
            n = n & (n - 1);
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(7 & 6);
    }
}

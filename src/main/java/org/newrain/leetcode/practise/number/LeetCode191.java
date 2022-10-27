package org.newrain.leetcode.practise.number;

/**
 * @author newrain
 */
public class LeetCode191 {


    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);//相当于减一操作
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(7 & 6);
    }
}

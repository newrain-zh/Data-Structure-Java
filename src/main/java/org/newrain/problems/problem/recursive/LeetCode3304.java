package org.newrain.problems.problem.recursive;


/**
 * <a href="https://leetcode.cn/problems/find-the-k-th-character-in-string-game-i/">...</a>
 */
public class LeetCode3304 {


    // 本质上就是统计二进制中1的个数（k从1开始，要减1）
    public char kthCharacter(int k) {
        int count = Integer.bitCount(k - 1);
        return (char) ('a' + count % 26);
    }
}
package org.newrain.problems.problem.base;

/**
 * leetcode.1009 十进制整数的反码
 * 每个非负整数 N 都有其二进制表示。例如， 5 可以被表示为二进制 "101"，11 可以用二进制 "1011" 表示，依此类推。
 *
 * 注意，除 N = 0 外，任何二进制表示中都不含前导零。
 * <p>
 * 二进制的反码表示是将每个 1 改为 0 且每个 0 变为 1。例如，二进制数 "101" 的二进制反码为 "010"。
 * <p>
 * 给你一个十进制数 N，请你返回其二进制表示的反码所对应的十进制整数。
 */
public class BitwiseComplement {


    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1; // 对于N=0，返回反码为1
        }

        // 计算N的二进制表示的位数
        int bitCount = (int) (Math.log(n) / Math.log(2)) + 1;

        // 计算反码
        //使用 (int) Math.pow(2, bitCount) - 1 来生成一个全部为1的数
        //从中减去N，即可得到反码。
        return (int) Math.pow(2, bitCount) - 1 - n;
    }
}
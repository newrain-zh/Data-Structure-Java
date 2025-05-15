package org.newrain.problems.problem.math;


/**
 * LeetCode190 颠倒二进制位
 *
 * TODO: 标记一下
 */
public class LeetCode190 {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= n & 1;
            n >>= 1;
        }
        return res;
    }

    // api 方式
    public static int reverseBits1(int n) {
        char[] chars = new char[32]; // 转换成 32位
        for (int i = 31; i >= 0; i--) {
            chars[31 - i] = (n & (1 << i)) != 0 ? '1' : '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(reverseBits1(43261596));
    }


}
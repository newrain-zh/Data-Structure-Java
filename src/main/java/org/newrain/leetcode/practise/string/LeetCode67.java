package org.newrain.leetcode.practise.string;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0
 */
public class LeetCode67 {

    public static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int len = Math.max(charsA.length, charsB.length);
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < len; ++i) {
            //'1' - '0' = 1
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append(carry % 2);
            carry /= 2;
        }
        ans.append(carry == 1 ? carry : "");// 判断最后一次计算是否有进位  有则在最前面加上1 否则原样输出
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println('1' - '0');
    }

}

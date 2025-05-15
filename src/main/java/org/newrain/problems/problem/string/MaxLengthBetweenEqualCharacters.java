package org.newrain.problems.problem.string;

/**
 * leetcode.1624 两个相同字符之间的最长子字符串
 * @author NewRain
 * @description 两个相同字符之间的最长子字符串
 * @link <a href="https://leetcode.cn/problems/largest-substring-between-two-equal-characters/"></>
 */
public class MaxLengthBetweenEqualCharacters {


    public static int maxLengthBetweenEqualCharacters(String s) {
        int cnt = -1;
        for (int i = 0; i < s.length(); i++) {
            int n = s.lastIndexOf(s.charAt(i));
            cnt = Math.max(cnt, n - i - 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));
        System.out.println(maxLengthBetweenEqualCharacters("abca"));
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
        System.out.println(maxLengthBetweenEqualCharacters("scayofdzca"));
    }
}
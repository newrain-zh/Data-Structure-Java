package org.newrain.code.problem.string;

/**
 * @author NewRain
 * @description 最长回文串
 * @link <a href="https://leetcode.cn/problems/longest-palindrome/">leetcode</>
 * @link <a href="https://www.lintcode.com/problem/627/">lintcode</a>
 * @tag 字符串 String
 */
public class LeetCode409 {

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return 1;
        }
        int[] arr = new int[128];
        for (char aChar : chars) {
            arr[aChar] += 1;
        }
        //oneChance = 表示只能有一个不重复字符串
        int oneChance = 0, maxLen = 0;
        for (int j : arr) {
            if (j % 2 == 0) {
                maxLen += j;
            } else if (j % 2 == 1) {
                maxLen = maxLen + (j / 2 * 2);
                if (oneChance == 0) {
                    maxLen += 1;
                    oneChance = 1;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
package org.newrain.leetcode.problem.string;

/**
 * @author newrain
 * @description 最长回文字符串
 * @link <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">...</a>
 * @link <a href="https://www.lintcode.com/problem/200/">lintcode</a>
 */
public class LongestPalindrome {

    /**
     * 中心扩散
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        //先判断特殊情况
        if (s == null || s.isEmpty() || s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        //最长长度       起始位置
        int maxLen = 0, start = 0;
        int length = chars.length;
        for (int i = 0; i < length; ) {
            //减少判断 如果剩余字符串小于最长回文字符串
            if (length - i <= maxLen / 2) {
                break;
            }
            int left = i, right = i;
            //重复字符串 例如 "aaaaaa"
            while (right < length - 1 && chars[right] == chars[right + 1]) {
                ++right;
            }
            i = right + 1;
            //向左右两边判断
            while (left > 0 && right < length - 1 && chars[right + 1] == chars[left - 1]) {
                --left;
                ++right;
            }
            //判断是否为最长的回文
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        String str = "cbbd";
        System.out.println(longestPalindrome(str));
    }
}

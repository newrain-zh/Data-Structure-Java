package org.newrain.code.problem.array;


/**
 * 题目：leetcode.2108 找出数组中的第一个回文字符串
 * 给你一个字符串数组 words ，找出并返回数组中的 第一个回文字符串 。如果不存在满足要求的字符串，返回一个 空字符串 "" 。
 *
 * 回文字符串 的定义为：如果一个字符串正着读和反着读一样，那么该字符串就是一个 回文字符串 。
 */
public class FirstPalindrome {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    /**
     * 判断是否为回文字符串
     *
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string) {
        char[] charArray = string.toCharArray();
        int l = 0, r = string.length() - 1;
        while (l <= r) {
            if (charArray[l] != charArray[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 该方法会比上述方法的时间复杂度要低
     *
     * @param word
     * @return
     */
    public static boolean isPalindrome1(String word) {
        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abaa"));
        System.out.println(isPalindrome("aba"));
    }

}
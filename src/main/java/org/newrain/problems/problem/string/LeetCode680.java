package org.newrain.problems.problem.string;

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；
 * 否则，返回 false 。
 * 680. 验证回文串 II
 *<a href="https://leetcode.cn/problems/valid-palindrome-ii/">...</a>
 * @author NewRain
 */
public class LeetCode680 {


    public static boolean validPalindrome(String s) {
        if (s.length() == 1){
            return true;
        }
        boolean palindrome = isPalindrome(s.toCharArray(), 0, s.length() - 1);
        if (palindrome) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l< r){
            if (charArray[l] != charArray[r]) {
                return isPalindrome(charArray, l + 1, r) || isPalindrome(charArray, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public static boolean isPalindrome(char[] charArray, int l, int r) {
        while (l < r) {
            if (charArray[l] != charArray[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba")); // true
        System.out.println(validPalindrome("abca")); // true
        System.out.println(validPalindrome("abc")); // false
        System.out.println(validPalindrome("atbbga")); // false
        System.out.println(validPalindrome("deeee")); // true


    }

}
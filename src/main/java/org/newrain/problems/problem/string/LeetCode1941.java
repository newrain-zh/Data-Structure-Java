package org.newrain.problems.problem.string;

/**
 * 1941.检查是否所有字符出现两次
 *
 * @author NewRain
 * <a href="https://leetcode.cn/problems/check-if-all-characters-have-equal-number-of-occurrences">...</a>
 */
public class LeetCode1941 {


    public static boolean areOccurrencesEqual(String s) {
        int[] arr = new int[26];
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            int index = c - 'a';
            if (arr[index] == -1) {
                arr[index] = 0;
            }
            arr[index]++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && count == 0) {
                count = arr[i];
            }
            if (arr[i] > 0 && count != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc")); // true
        System.out.println(areOccurrencesEqual("aaabb")); // false
    }
}
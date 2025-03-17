package org.newrain.problems.problem.string;


/**
 *
 * LeetCode.389. 找不同
 * <a href="https://leetcode.cn/problems/find-the-difference/">...</a>
 */
public class LeetCode389 {

    public static char findTheDifference(String s, String t) {
        if (s.isEmpty()) {
            return t.charAt(0);
        }
        char[] charArray = s.toCharArray();
        int[] arr = new int[26];
        for (char c : charArray) {
            arr[c - 'a']++;
        }
        char[] charArray1 = t.toCharArray();
        for (char c : charArray1) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }

    public static char findTheDifference1(String s, String t) {
        if (s.isEmpty()) {
            return t.charAt(0);
        }
        char[] charArray1 = t.toCharArray();
        char[] charArray2 = s.toCharArray();
        int[] arr = new int[26];
        for (int i = 0; i < charArray2.length; i++) {
            arr[charArray1[i] - 'a']++;
            arr[charArray2[i] - 'a']++;
        }
        arr[charArray1[charArray1.length - 1] - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (arr[i] % 2 != 0) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }

    /**
     * 最优解法
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference2(String s, String t) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum -= c;
        }

        for (char c : t.toCharArray()) {
            sum += c;
        }

        return (char) sum;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference1("abcd", "abcde"));
        System.out.println(findTheDifference1("", "y"));
    }

}
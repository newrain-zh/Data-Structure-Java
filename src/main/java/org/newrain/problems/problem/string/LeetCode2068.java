package org.newrain.problems.problem.string;

/**
 * 2068. 检查两个字符串是否几乎相等
 *
 * @author NewRain
 */
public class LeetCode2068 {


    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] arr1 = new int[26];
        char[] charArray1 = word1.toCharArray();
        for (char c : charArray1) {
            arr1[c - 'a']++;
        }
        int[] arr2 = new int[26];
        char[] charArray2 = word2.toCharArray();
        for (char c : charArray2) {
            arr2[c - 'a']++;
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Math.abs(arr1[i] - arr2[i]);
            if (arr1[i] > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa","bccb"));
        System.out.println(checkAlmostEquivalent("abcdeef","abaaacc"));
    }
}
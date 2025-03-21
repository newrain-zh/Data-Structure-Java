package org.newrain.problems.cracking;

import java.util.HashSet;
import java.util.Set;

/**
 * @author NewRain
 * @description 回文排列
 * @link <a href="https://leetcode.cn/problems/palindrome-permutation-lcci/"></a>
 */
public class CanPermutePalindrome {

    /**
     * Ascii码计数法
     */
    public static boolean canPermutePalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        }
        byte[] cnt = new byte[128];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            cnt[ch]++;
        }
        byte count = 0;
        for (byte j : cnt) {
            if (count > (byte) 1) {
                return false;
            }
            if (j % (byte) 2 != 0) {
                count++;
            }
        }
        return true;
    }


    public static boolean canPermutePalindrome1(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        Set<Character> set = new HashSet<>(length);
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        return set.size() <= 1;

    }


    public static void main(String[] args) {
        System.out.println(canPermutePalindrome1("AaBb//a"));
    }
}
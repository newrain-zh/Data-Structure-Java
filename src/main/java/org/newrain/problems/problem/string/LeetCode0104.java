package org.newrain.problems.problem.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 面试题 01.04. 回文排列
 */
public class LeetCode0104 {


    public static boolean canPermutePalindrome(String s) {
        Map<Character, Integer> dict   = new HashMap<>();
        int                     length = s.length();
        for (int i = 0; i < length; i++) {
            char key = s.charAt(i);
            dict.put(key, dict.getOrDefault(key, 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> entries = dict.entrySet();
        boolean                            isOdd   = length % 2 == 0;
        int                                count   = 1;
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            if (isOdd && value % 2 != 0) {
                return false;
            }
            if (value % 2 != 0) {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("tactcoa"));
    }
}
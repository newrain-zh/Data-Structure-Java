package org.newrain.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int left = -1;
        int max = 0;
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int right = 0; right < chars.length; right++) {
            if (characterIntegerMap.containsKey(chars[right])) {
                left = Math.max(characterIntegerMap.get(chars[right]), left);
            }
            characterIntegerMap.put(chars[right], right);
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}

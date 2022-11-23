package org.newrain.leetcode.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author newRain
 * @description 无重复字符的最长子串
 * @complexity middle
 */
public class LeetCode3 {

    public static int lengthOfLongestSubstring(String s) {
        //记录所有字符最近出现的位置
        Map<Character, Integer> map = new HashMap<>(s.length());
        int l = 0, maxL = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = map.getOrDefault(s.charAt(i), -1);
            l = Math.max(l, index + 1);
            maxL = Math.max(maxL, i - l + 1);
            map.put(s.charAt(i), i);
        }
        return maxL;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }


}

package org.newrain.leetcode.practise.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * @author newrain
 */
public class LeetCode387 {


    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>(chars.length);
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            } else {
                map.put(aChar, 0);
            }
        }
        for (Character key : map.keySet()) {
            if (map.get(key) == 0) {
                return s.indexOf(key);
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}

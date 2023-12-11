package org.newrain.code.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode.242 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * <p>
 * <p>
 */
public class IsAnagram {

    /**
     * 利用map解法
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>(t.length());
        char[] charList = t.toCharArray();
        for (char c : charList) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (Character key : map1.keySet()) {
            Integer integer = map1.get(key);
            Integer orDefault = map2.getOrDefault(key, 0);
            if (!integer.equals(orDefault)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }

}
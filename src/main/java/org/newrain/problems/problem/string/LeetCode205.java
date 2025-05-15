package org.newrain.problems.problem.string;


import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 205. 同构字符串
 */
public class LeetCode205 {

    // TODO 待优化
    public static boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> sDict = new HashMap<>(length);
        Map<Character, Character> tDict = new HashMap<>(length);
        // s -> t
        for (int i = 0; i < length; i++) {
            if (sDict.containsKey(s.charAt(i)) && sDict.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            } else if (tDict.containsKey(t.charAt(i)) && tDict.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            sDict.put(s.charAt(i), t.charAt(i));
            tDict.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
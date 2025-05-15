package org.newrain.problems.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode.383 赎金信
 *
 * @author newrain
 */
public class CanConstruct {

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (!ransomNote.isEmpty() && magazine.isEmpty()) {
            return false;
        }
        char[] chars = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<>(chars.length);
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char[] chars1 = ransomNote.toCharArray();
        for (char c1 : chars1) {
            if (!map.containsKey(c1)) {
                return false;
            }
            if (map.get(c1) <= 0) {
                return false;
            }
            map.put(c1, map.get(c1) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "aab"));
    }
}
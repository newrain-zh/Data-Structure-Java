package org.newrain.problems.problem.string;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 290 单词规律
 */
public class LeetCode290 {

    // TODO
    public static boolean wordPattern(String pattern, String s) {
        char[] charArray = pattern.toCharArray();
        String[] s1 = s.split(" ");
        if (charArray.length != s1.length) {
            return false;
        }
        Map<Character, String> dict = new HashMap<>(charArray.length);
        Map<String, Character> charMap = new HashMap<>(charArray.length);
        for (int i = 0; i < charArray.length; i++) {
            if (dict.containsKey(charArray[i])) {
                if (!dict.get(charArray[i]).equals(s1[i])) {
                    return false;
                }

            } else if (charMap.get(s1[i]) != null && charMap.get(s1[i]) != charArray[i]) {
                return false;
            } else {
                charMap.put(s1[i], charArray[i]);
                dict.put(charArray[i], s1[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));  // false
        System.out.println(wordPattern("abba", "dog dog dog dog"));  // false
        System.out.println(wordPattern("abc", "dog cat dog")); // false
    }
}
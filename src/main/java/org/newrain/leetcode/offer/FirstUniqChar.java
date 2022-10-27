package org.newrain.leetcode.offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {


    public static char firstUniqChar(String s) {
        Map<Character, Integer> posMap = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (posMap.containsKey(chars[i])) {
                posMap.put(chars[i], i);
            } else {
                posMap.put(chars[i], -1);
            }
        }
        char r = ' ';
        for (Map.Entry<Character, Integer> entry : posMap.entrySet()) {
            if (entry.getValue() == -1) {
                r = entry.getKey();
                break;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }
}

package org.newrain.leetcode.problem.string;

public class LeetCode709 {


    public static String toLowerCase(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] r = new char[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                r[i] = chars[i] |= 32;
            } else {
                r[i] = chars[i];
            }
        }
        return new String(r);
    }


    public static String toLowerCase1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] r = new char[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                r[i] = chars[i] |= 32;
            } else {
                r[i] = chars[i];
            }
        }
        return new String(r);
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase1("HEllo@[]"));
        int charA = 'a';
        int chara = 'z';
        System.out.println(charA);
        System.out.println(chara);
    }
}

package org.newrain.problems.offer;

public class ReverseLeftWords {

    public static String reverseLeftWords(String s, int n) {
        if (n >= s.length()) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            res.append(chars[i]);
        }
        return res.toString();
    }

    public static String reverseLeftWords1(String s, int n) {
        if (n >= s.length()) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("abcdefg", 2).equals("cdefgab"));
        System.out.println(reverseLeftWords1("abcdefg", 2).equals("cdefgab"));
    }
}
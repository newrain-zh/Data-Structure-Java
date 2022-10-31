package org.newrain.leetcode.problem.string;

public class LeetCode1816 {


    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        if (k == 0) {
            return s1[0];
        }
        if (k == s1.length) {
            return s;
        }
        String result = "";
        for (int i = 0; i < k; i++) {
            result += s1[i];
            if (i + 1 != k) {
                result += " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 5));
    }
}

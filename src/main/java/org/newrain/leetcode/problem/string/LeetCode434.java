package org.newrain.leetcode.problem.string;

public class LeetCode434 {

    public static int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] s1 = s.split(" ");
        int count = 0;
        for (String str : s1) {
            if (str.length() == 0) {
                continue;
            }
            if (str.contains(" ")) {
                String replace = str.replace(" ", "");
                if (replace.length() > 0) {
                    count = count + 1;
                }
            } else {
                count = count + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSegments(", , , ,        a, eaefa"));
    }
}

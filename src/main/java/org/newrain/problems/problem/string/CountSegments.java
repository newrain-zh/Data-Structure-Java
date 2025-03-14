package org.newrain.problems.problem.string;

/**
 * leetcode.434 字符串中的单词数
 */
public class CountSegments {

    public static int countSegments(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] s1 = s.split(" ");
        int count = 0;
        for (String str : s1) {
            if (str.isEmpty()) {
                continue;
            }
            if (str.contains(" ")) {
                String replace = str.replace(" ", "");
                if (!replace.isEmpty()) {
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
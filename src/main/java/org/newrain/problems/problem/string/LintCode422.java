package org.newrain.problems.problem.string;

public class LintCode422 {
    public int lengthOfLastWord(String s) {
        // write your code here
        if (s.length() == 0) {
            return 0;
        }
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }
}
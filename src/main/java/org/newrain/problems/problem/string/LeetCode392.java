package org.newrain.problems.problem.string;

/**
 * 392. 判断子序列
 * <a href="https://leetcode-cn.com/problems/is-subsequence/">...</a>
 *
 */
public class LeetCode392 {

    /**
     * 判断 s 是否是 t的子序列
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        char[] charArray1 = s.toCharArray();
        int lastIndex = 0;
        for (char c : charArray1) {
            int currentIndex = t.indexOf(c, lastIndex);
            if (currentIndex == -1) {
                return false;
            } else {
                lastIndex = currentIndex + 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }
}
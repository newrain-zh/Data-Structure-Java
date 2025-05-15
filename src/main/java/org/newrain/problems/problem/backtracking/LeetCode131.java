package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分割回文串
 */
public class LeetCode131 {

    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(String s, int start, List<String> path) {
        System.out.println("当前path: " + path + ", startIndex = " + start);
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 分割字符串 [start,end]
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String s, int left, int right) {
        if (s.length() == 1) {
            return true;
        }
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> aab = new LeetCode131().partition("abc");
        aab.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }
}
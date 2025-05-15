package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效的括号
 */
public class LeetCode0809 {


    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtracking("", n, 0, 0);
        return ans;
    }

    private void backtracking(String path, int n, int open, int close) {
        if (open > n || close > open) {
            return;
        }
        if (path.length() == 2 * n) {
            ans.add(path);
            return;
        }
        backtracking(path + "(", n, open + 1, close);
        backtracking(path + ")", n, open, close + 1);
    }

    public static void main(String[] args) {
        List<String> strings = new LeetCode0809().generateParenthesis(3);
        System.out.println(strings);

    }
}
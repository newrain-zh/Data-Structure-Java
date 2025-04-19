package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 删除无效的括号
 */
public class LeetCode301 {

    List<String> ans = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        backtrack(0, "", s);
        return ans;
    }

    private void backtrack(int usedIndex, String path, String s) {
        if (usedIndex == s.length()) {
            if (isValid(path)) {
                ans.add(path);
            }
            return;
        }
        for (int i = usedIndex; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            StringBuilder stringBuilder = sb.deleteCharAt(usedIndex);
            if (isValid(stringBuilder.toString())) {
                path += stringBuilder;
                backtrack(i + 2, path, s);
                path = path.substring(0, path.length() - 1);
            }
        }
    }


    public static boolean isValid(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '(' && string.charAt(i) != ')') {
                continue;
            }
            if (string.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(a())()"));
    }

}
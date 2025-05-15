package org.newrain.problems.problem.stack;

import java.util.Stack;

/**
 * 最长有效括号
 */
public class LeetCode32 {


    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        char[]         array = s.toCharArray();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < array.length; i++) {
            if ('(' == array[i]) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    if (len > maxLen) {
                        maxLen = len;
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())"));
    }
}
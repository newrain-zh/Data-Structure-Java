package org.newrain.code.problem.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author NewRain
 * @description 有效的括号序列
 * @link <a href="https://www.lintcode.com/problem/423">lintcode</a>
 * @link <a href="https://leetcode.cn/problems/valid-parentheses/">leetcode</a>
 * @tag 栈 stack 字符串 String
 */
public class LintCode423 {

    /**
     * @param s: A string
     * @return whether the string is a valid parentheses
     */
    public static boolean isValidParentheses(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> dict = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (dict.containsKey(ch)) {
                //如果栈为空说明出现不对称的情况
                //栈顶的值为左括号 如果换个当前的右括号不匹配
                if (stack.isEmpty() || !stack.peek().equals(dict.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("([)]"));
    }
}
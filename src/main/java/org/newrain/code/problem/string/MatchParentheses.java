package org.newrain.code.problem.string;

import java.util.Stack;

/**
 * @author NewRain
 * @description 小括号匹配
 * @link <a href="https://www.lintcode.com/problem/263">lintcode</a>
 * @tag 栈 stack
 */
public class MatchParentheses {

    /**
     * 利用栈来解决匹配问题
     *
     * @param string
     * @return boolean
     */
    public boolean matchParentheses(String string) {
        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
        for (char aChar : chars) {
            if (')' == aChar) {
                //说明出现不对称情况
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }

            } else if ('(' == aChar) {
                stack.push('(');
            }
        }
        return stack.isEmpty();
    }
}
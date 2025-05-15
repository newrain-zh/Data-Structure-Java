package org.newrain.problems.problem.string;

import java.util.Stack;

/**
 * leetcode.678 有效的括号字符串
 *
 * @link <a href="https://leetcode.cn/problems/valid-parenthesis-string/description/">...</a>
 * 给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是有效字符串返回 true 。
 * <p>
 * 有效字符串符合如下规则：
 * <p>
 * 任何左括号 '(' 必须有相应的右括号 ')'。
 * <p>
 * 任何右括号 ')' 必须有相应的左括号 '(' 。
 * <p>
 * 左括号 '(' 必须在对应的右括号之前 ')'。
 * <p>
 * '*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串。
 * <p>
 * 一个空字符串也被视为有效字符串。
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * <p>
 * 输出：true
 */
public class CheckValidString {

    /**
     * 使用栈的思路解决该问题
     *
     * @param s
     * @return
     */
    public static boolean checkValidString(String s) {
        Stack<Integer> bracketStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                starStack.push(i);
                continue;
            }
            if ('(' == c) {
                bracketStack.push(i);//放入(位置
            } else {
                if (!bracketStack.isEmpty()) {
                    bracketStack.pop();
                } else {
                    //使用*元素进行消除不匹配的元素
                    if (!starStack.isEmpty()) {
                        starStack.pop();
                    } else { //无法消除直接返回
                        return false;
                    }
                }
            }
        }
        if (starStack.size() < bracketStack.size()) {//*号小于) 说明不够替换
            return false;
        }
        while (!bracketStack.empty()) {
            // * 必须排在 ( 后面才能当做 ）用
            if (bracketStack.pop() > starStack.pop()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkValidString1(String s) {
        //最低左括号计数 在最悲观的情况下，假设所有的 * 都是右括号)或空字符串，
        //计算可能的最少左括号数量。
        int minOpen = 0;
        //最高左括号计数
        //在最乐观的情况下，假设所有的 * 都是左括号，计算可能的最多左括号(数量。
        int maxOpen = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (')' == c) {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
                // 在任何时候，如果 maxOpen 变为负数，意味着右括号)过多，
                // 无法形成有效的字符串，返回 false。
                if (maxOpen < 0) {
                    return false;
                }
            } else if ('*' == c) {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen++;
            }
        }
        // 在遍历结束后，如果 minOpen 为 0，
        // 意味着存在一种 * 的合理分配方法可以使左右括号平衡，
        // 返回 true。如果 minOpen 大于 0，意味着左括号过多，返回 false。
        return minOpen == 0;
    }

    public static void main(String[] args) {
//        System.out.println(checkValidString("(*))"));
//        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

}
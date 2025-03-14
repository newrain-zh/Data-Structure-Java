package org.newrain.problems.problem.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author NewRain
 * @description 删除不匹配的括号
 * @link <a href="https://leetcode.cn/problems/minimum-remove-to-make-valid-parentheses/">leetcode</a>
 * @link <a href="https://www.lintcode.com/problem/2506/">lintcode</a>
 * @tag 字符串 String
 */
public class RemoveParentheses {

    /**
     * 利用数组来存储'('的位置 遍历中若发现')' 则抵消
     *
     * @param s 原始字符串
     * @return 删除不匹配的括号后的字符
     */
    public static String removeParentheses(String s) {
        //stack保存了')'不对称的字符的索引
        List<Integer> stack = new ArrayList<>();
        //delIndex保存了'('冗余的字符索引
        Set<Integer> delIndex = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (')' == chars[i]) {
                //若栈为空则说明出现了'('和')'不对称的情况，记录下字符的索引
                if (stack.isEmpty()) {
                    delIndex.add(i);
                } else {
                    stack.remove(stack.size() - 1);
                }
            } else if ('(' == chars[i]) {
                stack.add(i);
            }
        }
        delIndex.addAll(stack);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!delIndex.contains(i)) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        //a(b(cde)fgh)
        System.out.println(removeParentheses("a(b(c(de)fgh)"));
        System.out.println(removeParentheses("tyweggadosw(sbvf)n(("));
        System.out.println(removeParentheses("((("));
        System.out.println(removeParentheses(")))"));
    }
}
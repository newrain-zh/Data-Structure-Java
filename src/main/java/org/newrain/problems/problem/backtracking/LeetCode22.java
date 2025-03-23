package org.newrain.problems.problem.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode.22 括号生成
 */
public class LeetCode22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        gen(n, "", ans, 0, 0);
        return ans;
    }

    public void gen(int n, String path, List<String> res, int open, int close) {
        if (open > n || close > open) {
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        gen(n, path + "(", res, open + 1, close);
        gen(n, path + ")", res, open, close + 1);
    }


    public static List<String> gen1(int n) {
        List<String> res = new ArrayList<>();
        // 使用栈模拟递归调用栈：存储（当前路径，已用左括号数，已用右括号数）
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{"", 0, 0}); // 路径 左括号数 右括号数

        while (!stack.isEmpty()) {
            Object[] frame = stack.pop();
            String   path  = (String) frame[0];
            int      left  = (Integer) frame[1];
            int      right = (Integer) frame[2];

            // 终止条件：路径长度达到2n
            if (path.length() == 2 * n) {
                res.add(path);
                continue;
            }

            // 模拟递归调用（注意栈的后进先出特性，顺序要反转）
            // 1. 先处理右括号分支（因为栈是LIFO）
            if (right < left) { // 可以添加右括号的条件
                stack.push(new Object[]{path + ")", left, right + 1});
            }
            // 2. 再处理左括号分支
            if (left < n) { // 可以添加左括号的条件
                stack.push(new Object[]{path + "(", left + 1, right});
            }
        }
        return res;

    }


    public static void main(String[] args) {
        System.out.println(new LeetCode22().generateParenthesis(2));
        System.out.println(gen1(2));
    }
}
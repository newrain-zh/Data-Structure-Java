package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * 生成括号
 * 给定 n，表示有 n 对括号, 请写一个函数以将其生成所有的括号组合，并返回组合结果。
 * 输入: 3
 * 输出: ["((()))", "(()())", "(())()", "()(())", "()()()"]
 */
public class LintCode427 {

    private final List<String> ans = new ArrayList<>();
    private       int          n;


    public List<String> generateParenthesis(int n) {
        this.n = n;
//        dfs("", 0, 0, new StringBuilder());
        dfs1(0, 0, "");
        return ans;
    }

    /**
     * ❌解法 这里有个问题 StringBuilder 每层共享的问题
     *
     * @param s     选择左括号还是右括号
     * @param open  左括号(
     * @param close 右括号)
     * @param path  路径
     */
    private void dfs(String s, int open, int close, StringBuilder path) {
        if (open > n || close > open) {
            return;
        }
        if (path.length() == n * 2) { // 左括号+右括号的数量
            ans.add(path.toString());
            return;
        }

       /*

        if (path.length() == n * 2) { // 左括号+右括号的数量
            ans.add(path.toString());
            return;
        }
         if (open > n || close > open) {
            return;
        }

        path.append(s);
        dfs("(", open + 1, close, path);
        dfs(")", open, close + 1, path); // 如果第一个结果(()) 产生了，会执行这里，可是回溯的代码在这个下一行，会先递归去下一层，导致产生重复结果
        if (path.length() > 0) {
            path.deleteCharAt(path.length() - 1);
            System.out.println("回溯" + path);
        }
        */
        path.append("(");
        dfs("(", open + 1, close, path);
        path.deleteCharAt(path.length() - 1); // 回溯
        // 尝试加一个右括号
        path.append(')');
        dfs(")", open, close + 1, path); // 如果第一个结果(()) 产生了，会执行这里，可是回溯的代码在这个下一行，会先递归去下一层，导致产生重复结果
        path.deleteCharAt(path.length() - 1); // 回溯

    }

    public void dfs1(int open, int close, String path) {
        if (open > n || close > open) {
            return;
        }
        if (path.length() == 2 * n) {
            ans.add(path);
            return;
        }
        dfs1(open + 1, close, path + "(");
        dfs1(open, close + 1, path + ")");

    }


    public static void main(String[] args) {
        List<String> list = new LintCode427().generateParenthesis(2);
        System.out.println("result----");
        list.forEach(System.out::println);
    }


}
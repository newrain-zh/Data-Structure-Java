package org.newrain.leetcode.problem.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author newRain
 * @link <a href="https://leetcode.cn/problems/combinations/">...</a>
 * @description 组合
 * @complexity middle
 * @tag 递归 回溯 暴力枚举
 */
public class LeetCode77 {


    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    /**
     * @param n     范围
     * @param k     个数
     * @param begin 开始位置
     * @param path  当前的组合的队列
     * @param res   最后的结果集
     */
    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        combine(5, 3);
    }

}

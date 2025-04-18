package org.newrain.problems.problem.backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/combinations/description">...</a>
 */
public class LeetCode77 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return null;
    }

    public void backtracking(int[] arr, boolean[] used, List<Integer> path) {
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]){
                used[i] = true;
                path.add(arr[i]);
                backtracking(arr, used, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
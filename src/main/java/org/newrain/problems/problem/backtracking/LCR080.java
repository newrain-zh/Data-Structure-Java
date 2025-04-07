package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 080. 组合
 */
public class LCR080 {

    List<List<Integer>> ans = new ArrayList<>();
    int                 k;

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        backtracking(arr, 0, new ArrayList<>());
        return ans;
    }

    /*
     * 想象一下是个 N 叉树遍历问题
     * TODO 待图解
     */
    public void backtracking(int[] arr, int start, List<Integer> path) {
        if (path.size() == k) {
            System.out.println("start=" + start + " ,arr=" + Arrays.toString(path.toArray()));
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            backtracking(arr, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public void backtracking1(int[] arr, int start, List<Integer> path) {
        for (int i = start + 1; i < arr.length; i++) {
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new LCR080().combine(4, 3);
        combine.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }

}
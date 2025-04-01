package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode216. 组合总和 III
 */
public class LeetCode216 {

    public int k; // 要求的个数

    public int target; // 目标和

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int target) {
        this.k      = k;
        this.target = target;
        int[] arr = new int[9];
        for (int i = 1; i < 10; i++) {
            arr[i - 1] = i;
        }
        backtrack(arr, 0, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] arr, int start, int sum, List<Integer> path) {
        if (path.size() == k && sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (sum + arr[i] > target) { // 剪枝
                break;
            }
            path.add(arr[i]);
            backtrack(arr, i + 1, sum + arr[i], path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> list = new LeetCode216().combinationSum3(3, 7); // [1,2,4]
//        List<List<Integer>> list = new LeetCode216().combinationSum3(3, 9); // [1,2,6] [1,3,5] [2,3,4]
        List<List<Integer>> list = new LeetCode216().combinationSum3(4, 1); // [1,2,6] [1,3,5] [2,3,4]
        list.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }
}
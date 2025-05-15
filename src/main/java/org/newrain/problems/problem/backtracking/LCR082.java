package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LCR082 {

    private int                 target;
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtrack(candidates, 0, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] arr, int start, int currSum, List<Integer> path) {
        if (currSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
//        System.out.println("start=" + stxx3art + ",num=" + arr[start] + ",currSum=" + currSum);
        System.out.println("path=" + path);
        for (int i = start; i < arr.length; i++) {
            int sum = arr[i] + currSum;
            if (sum > target) {
                break;
            }
            if (i > start && arr[i - 1] == arr[i]) {
                continue;
            }
            path.add(arr[i]);
            backtrack(arr, i + 1, arr[i] + currSum, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new LCR082().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        list.forEach(v -> {
            System.out.println(Arrays.toString(v.toArray()));
        });
    }
}
package org.newrain.example.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private static void backtrack(int[] arr, int index, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == arr.length) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            path.add(arr[i]);  // 加入当前路径
            backtrack(arr, index++, path, ans);
            path.remove(path.size() - 1);
        }

    }

    private class State {
        int[]     arr;
        int       index;
        boolean[] used;

        public State(int[] arr, int index, boolean[] used) {
            this.arr   = arr;
            this.index = index;
            this.used  = used;
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
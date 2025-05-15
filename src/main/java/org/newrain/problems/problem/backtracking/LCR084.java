package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列II
 */
public class LCR084 {


    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    private void backtracking(int[] arr, int startIndex, boolean[] used, List<Integer> path) {
        if (path.size() == arr.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((i > 0 && arr[i - 1] == arr[i]) && !used[i - 1]) { // 同一层级 当前元素不能与前一个相同 !used[i - 1] 表示前一个元素已经使用过了
                continue;
            }
            if (!used[i]) {
                used[i] = true; // 表示当前元素已占用
                path.add(arr[i]);
                backtracking(arr, i + 1, used, path);
                used[i] = false;
                path.remove(path.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        LCR084              lcr084 = new LCR084();
        List<List<Integer>> list   = lcr084.permuteUnique(new int[]{1, 1, 2});
        list.forEach(System.out::println);
    }
}
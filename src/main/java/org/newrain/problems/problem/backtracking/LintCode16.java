package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 带重复元素的排列
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 */
public class LintCode16 {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] arr, boolean[] used, List<Integer> path) {
        if (path.size() == arr.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            // 前一个一模一样的元素还没被用，那说明我们是在“同一层（横向）”递归。我们已经选过一个了，后面这个就跳过

            // i>0 说明循环向后移动过
            // arr[i] == arr[i - 1] 表示当前元素与前面元素相同
            // used[i-1]=false 表示前面一个元素还没使用 && !used[i - 1]
          /*  if (i > 0 && arr[i] == arr[i - 1]) { // 当前这个值和前一个一样，但前一个还没用过
                continue;
            }*/
            path.add(arr[i]);
            used[i] = true;
            backtrack(arr, used, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        LintCode16          lintCode16 = new LintCode16();
        List<List<Integer>> lists      = lintCode16.permuteUnique(new int[]{1, 1, 2});
        lists.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }


}
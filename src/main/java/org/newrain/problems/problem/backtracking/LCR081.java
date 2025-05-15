package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR081.组合总和
 */
public class LCR081 {

    private List<List<Integer>> ans = new ArrayList<>();
    private int                 target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, new ArrayList<>());
        return ans;
    }

    /*
       arr=[2,3,6,7] target=7
     *初始调用: backtracking(arr, start=0, sum=0, path=[])
       ├─ 循环 i=0 (元素2):
       │  ├─ 添加2 → path=[2], sum=2
       │  │  └─ 递归调用 backtracking(start=0, sum=2)
       │  │     ├─ 循环 i=0 (元素2):
       │  │     │  ├─ 添加2 → path=[2,2], sum=4
       │  │     │  │  └─ 递归调用 backtracking(start=0, sum=4)
       │  │     │  │     ├─ 循环 i=0 (元素2):
       │  │     │  │     │  ├─ 添加2 → sum=6 → path=[2,2,2]
       │  │     │  │     │  │  └─ 递归调用 backtracking(start=0, sum=6)
       │  │     │  │     │  │     ├─ 循环 i=0 (元素2):
       │  │     │  │     │  │     │  └─ sum+2=8 >7 → 剪枝
       │  │     │  │     │  │     └─ 回溯移除2 → path=[2,2]
       │  │     │  │     │  └─ 循环 i=1 (元素3):
       │  │     │  │     │     ├─ 添加3 → sum=7 → 保存 [2,2,3]
       │  │     │  │     │     └─ 回溯移除3 → path=[2,2]
       │  │     │  │     └─ 回溯移除2 → path=[2]
       │  │     │  └─ 循环 i=1 (元素3):
       │  │     │     └─ 添加3 → sum=5 → 递归调用（后续无法达成7）
       │  │     └─ 回溯移除3 → path=[2]
       │  └─ 回溯移除2 → path=[]
       │
       ├─ 循环 i=1 (元素3):
       │  └─ 添加3 → sum=3 → 递归调用（后续无法达成7）
       │
       ├─ 循环 i=2 (元素6):
       │  └─ 添加6 → sum=6 → 递归调用（后续无法达成7）
       │
       └─ 循环 i=3 (元素7):
          └─ 添加7 → sum=7 → 保存 [7]
     */
    public void backtracking(int[] arr, int start, int sum, List<Integer> path) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            // 不排序 这里就无法尝试后面更小的元素
            if (sum + arr[i] > target) {
                break;
            }
            path.add(arr[i]);
            backtracking(arr, i, arr[i] + sum, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> list = new LCR081().combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> list = new LCR081().combinationSum(new int[]{2, 7, 6, 3, 5, 1}, 9);
        list.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
    }
}
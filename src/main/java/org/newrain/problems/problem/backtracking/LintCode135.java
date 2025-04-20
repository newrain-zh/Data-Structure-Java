package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LintCode.135 数字组合
 */
public class LintCode135 {


    private List<List<Integer>> ans = new ArrayList<>();

    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        backtrack(candidates, 0, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] arr, int startIndex, int currSum, List<Integer> path) {
        if (currSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            if (currSum + arr[i] > target) {
                break;
            }
            // startIndex 相当于每层递归中的循环的起始元素 可以作为深度的一个标识
            // i > 0 说明本层递归循环中向后移动了
            if (i > 0 && arr[i] < arr[startIndex]) { // 组合之内的元素必须是升序的
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1]) { // 去重 同一层级 不能使用重复元素
                continue;
            }
            path.add(arr[i]); // 选择元素
            backtrack(arr, i, currSum + arr[i], path); // 选择下一个元素 可重复 直接选择 本层的索引
            path.remove(path.size() - 1);
        }
    }


    /*public void backtrack(int[] arr, int currSum, List<Integer> path) {
        if (currSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (currSum + arr[i] > target) {
                break;
            }
            // 这里是保持选择的元素是升序的 通过当前元素与上个选择的元素进行比对
            // 效率较差 因为要遍历 path路径
            if (!path.isEmpty() && arr[i] < path.get(path.size() - 1)) { // 组内元素保持升序
                continue;
            }
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            path.add(arr[i]);
            backtrack(arr, currSum + arr[i], path);
            path.remove(path.size() - 1);
        }
    }*/

    public static void main(String[] args) {
        List<List<Integer>> lists = new LintCode135().combinationSum(new int[]{2, 3, 6, 7}, 7);
//        List<List<Integer>> lists = new LintCode135().combinationSum(new int[]{2, 2, 3}, 5);
        lists.forEach(System.out::println);
    }

}
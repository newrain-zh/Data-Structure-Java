package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode.46 全排列
 * @author NewRain
 * <a href="https://leetcode.cn/problems/permutations/description/">...</a>
 */
public class LeetCode46 {


    public List<List<Integer>> ans = new ArrayList<>();

    /**
     * nums 规则
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 用于记录元素是否被使用过
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), result, used);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, boolean[] used) {
        // 当前排列长度等于数组长度时，将结果加入列表
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 遍历所有元素，选择未使用的加入当前排列
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);      // 选择当前元素
                used[i] = true;            // 标记为已使用
                System.out.println("递进==>i=" + i + ",num=" + nums[i] + ",used=" + Arrays.toString(used) + ",path=" + path);
                backtrack(nums, path, result, used); // 递归处理下一位置
                path.remove(path.size() - 1); // 撤销选择
                used[i] = false;          // 恢复未使用状态
                System.out.println("递归<==i=" + i + ",num=" + nums[i] + ",used=" + Arrays.toString(used) + ",path=" + path);
            }
        }
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> result, Stack<Integer> stack) {
        // 当前排列长度等于数组长度时，将结果加入列表
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 遍历所有元素，选择未使用的加入当前排列
        for (int i = 0; i < nums.length; i++) {
        }

    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans   = new ArrayList<>();
        Stack<State>        stack = new Stack<>();
        stack.push(new State(new ArrayList<>(), new boolean[nums.length], 0));
        while (!stack.isEmpty()) {
            State currentState = stack.pop();
            if (currentState.path.size() == nums.length) {
                ans.add(currentState.path);
                continue;
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                if (!currentState.used[i]) {
                    List<Integer> newPath = new ArrayList<>(currentState.path);
                    newPath.add(nums[i]);
                    boolean[] newUsed = new boolean[nums.length];
                    System.arraycopy(currentState.used, 0, newUsed, 0, nums.length);
                    newUsed[i] = true;
                    stack.push(new State(newPath, newUsed, currentState.index + 1));
                }
            }
            System.out.println(stack);

        }
        return ans;
    }

    private static class State {

        private List<Integer> path; // 当前路径
        boolean[] used;  // 已经使用数组元素的状况
        int       index; // 当前处理的数组位置

        public State(List<Integer> path, boolean[] used, int index) {
            this.path  = path;
            this.used  = used;
            this.index = index;
        }

        @Override
        public String toString() {
            return " index=" + index + ",path=" + path + ",used=" + Arrays.toString(used) + "\n";
        }
    }


    public static void main(String[] args) {
//        System.out.println(new LeetCode46().permute(new int[]{1, 2, 3}));
        System.out.println(new LeetCode46().permute1(new int[]{1, 2, 3}));

    }
}
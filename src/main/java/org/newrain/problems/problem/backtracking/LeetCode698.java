package org.newrain.problems.problem.backtracking;

import java.util.Arrays;

/**
 * 划分为k个相等的子集
 */
public class LeetCode698 {


    /*
    给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
示例 1：
输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
     */


   /*
    private int target;
    ❌错误解法 解题思路不对
    private List<List<Integer>> ret = new ArrayList<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 先计算是否能被 k 整除 不能被整除说明不可能
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }

        Arrays.sort(nums);
        this.target = k;
        backtrack(nums, new boolean[nums.length], 0, new ArrayList<>());
        ret.forEach(v -> System.out.println(Arrays.toString(v.toArray())));
        return false;

    }

    public void backtrack(int[] nums, boolean[] used, int currentSum, List<Integer> path) {
        if (currentSum == target) {
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            if (nums[i] + currentSum > target) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, nums[i] + currentSum, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }*/


    /**
     * 要求是分成 k 个子数组，每个子数组之和都相等
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        this.target = sum / k;
        Arrays.sort(nums);
        reverse(nums);
        if (nums[0] > target) return false;
        return backtracking(nums, new boolean[nums.length], 0, k, 0);

    }

    private int target;

    public boolean backtracking(int[] arr, boolean[] used, int startIndex, int k, int currSum) {
        if (k == 0) {
            return true;
        }
        if (currSum == this.target) {
            return backtracking(arr, used, 0, k - 1, 0);
        }
        for (int i = startIndex; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝：同一层跳过重复值（避免对称分支）
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;
            if (currSum + arr[i] > target) {
                continue;
            }
            used[i] = true;
            if (backtracking(arr, used, i + 1, k, arr[i] + currSum)) {
                return true;
            }
            used[i] = false;
            // 关键剪枝：当前数填不进任何桶，可以跳过相同值
            //  currSum == 0 表示准备放进
            if (currSum == 0) return false;
        }
        return false;
    }

    public void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int t = nums[i];
            nums[i++] = nums[j];
            nums[j--] = t;
        }
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode698().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
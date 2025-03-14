package org.newrain.problems.problem.array;


import java.util.*;

/**
 * 题目：多个数组求交集
 * 给你一个二维整数数组 nums ，其中 nums[i] 是由 不同 正整数组成的一个非空数组，
 * 按 升序排列 返回一个数组，数组中的每个元素在 nums 所有数组 中都出现过。
 */
public class Intersection {

    public static void main(String[] args) {
        int[][] res = new int[][]{{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};
//        System.out.println(intersection(res));
        System.out.println(intersection2(res));
    }

    public static List<Integer> intersection(int[][] nums) {
        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].length < minP) {
                minP = i;
            }
        }
        int[] base = nums[minP];
        for (int i = 0; i < nums.length; i++) {
            if (i != minP) {
                base = getCommon(base, nums[i]);
            }
        }
        if (base.length == 0) {
            return new ArrayList<>(0);
        }
        Arrays.sort(base);
        List<Integer> ans = new ArrayList<>(base.length);
        for (int j : base) {
            ans.add(j);
        }
        return ans;
    }


    public static int[] getCommon(int[] base, int[] diff) {
        Set<Integer> set = new HashSet<>();
        for (int i : base) {
            set.add(i);
        }
        List<Integer> currCommon = new ArrayList<>();
        for (int i : diff) {
            if (set.contains(i)) {
                currCommon.add(i);
            }
        }
        if (currCommon.isEmpty()) {
            return new int[0];
        }
        int size = currCommon.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = currCommon.get(i);
        }
        return ans;
    }

    /**
     * 更秒的解题方法
     * @param nums
     * @return
     */
    public static List<Integer> intersection2(int[][] nums) {
        List<Integer> list = new ArrayList<>();
        int[] res = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                res[i]++; //如果每个数组都出现,该数出现的次数必定等于数组的长度
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] == nums.length) {
                list.add(i);
            }
        }
        return list;
    }

}
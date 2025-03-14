package org.newrain.problems.problem.array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 题目：leetcode.1313 解压缩编码列表
 * 给你一个以行程长度编码压缩的整数列表 nums 。
 * <p>
 * 考虑每对相邻的两个元素 [freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ）
 * ，每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
 * <p>
 * 请你返回解压后的列表。
 */
public class DecompressRLElist {


    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            add(list, nums[i + 1], nums[i]);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void add(List<Integer> ans, int value, int count) {
        for (int i = 0; i < count; i++) {
            ans.add(value);
        }
    }

    public static void main(String[] args) {
        //Arrays.fill(result, startIndex, endIndex, value);
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
    }
}
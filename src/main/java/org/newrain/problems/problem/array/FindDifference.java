package org.newrain.problems.problem.array;

import java.util.*;
import java.util.stream.Collectors;


/**
 * leetcode.2215 找出两数组的不同
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 * <p>
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出：[[1,3],[4,6]]
 * 解释：
 * 对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
 * 对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
 */
public class FindDifference {

    /**
     * 使用set集合实现
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1Dict = new HashSet<>(nums1.length);
        for (int j : nums1) {
            num1Dict.add(j);
        }
        Set<Integer> num2Dict = new HashSet<>(nums2.length);
        for (int i : nums2) {
            num2Dict.add(i);
        }

        List<List<Integer>> ans = new ArrayList<>(2);
        Set<Integer> ansList1 = new HashSet<>();
        //nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
        for (int j : nums1) {
            if (!num2Dict.contains(j)) {
                ansList1.add(j);
            }
        }
        Set<Integer> ansList2 = new HashSet<>();

        for (int j : nums2) {
            if (!num1Dict.contains(j)) {
                ansList2.add(j);
            }
        }
        ans.add(new ArrayList<>(ansList1));
        ans.add(new ArrayList<>(ansList2));
        return ans;
    }

    /**
     * java8写法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        return Arrays.asList(set1.stream().filter(x -> !set2.contains(x)).collect(Collectors.toList()), set2.stream().filter(x -> !set1.contains(x)).collect(Collectors.toList()));
    }

}
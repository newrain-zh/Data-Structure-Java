package org.newrain.code.problem.array;

import java.util.*;

/**
 * 题目：数组序号转换
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 */
public class ArrayRankTransform {


    public static int[] arrayRankTransform(int[] arr) {
        int[] sortArr = getUniqueArr(arr);
        Map<Integer, Integer> map = new HashMap<>(sortArr.length);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], i + 1);
            }
        }
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }

    public static int[] getUniqueArr(int[] arrays) {
        int length = arrays.length;
        Set<Integer> set = new HashSet<>(length);
        for (int array : arrays) {
            set.add(array);
        }
        List<Integer> ans = new ArrayList<>(set);
        ans.sort(Comparator.comparingInt(o -> o));
        int[] ansArray = new int[length];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(arrayRankTransform(new int[]{40, 10, 20, 30}))); //[4,1,2,3]
        System.out.println(Arrays.toString(arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}))); //[4,1,2,3]
    }
}
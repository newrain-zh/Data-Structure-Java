package org.newrain.problems.problem.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">...</a>
 */
public class LeetCode119 {


    // TODO 根据规律有更好的解决方式
    public static List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    /**
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> objects = new ArrayList<>(1);
        objects.add(1);
        res.add(objects);
        if (numRows == 1) {
            return res;
        }
        objects = new ArrayList<>(2);
        objects.add(1);
        objects.add(1);
        res.add(objects);
        if (numRows == 2) {
            return res;
        }
        objects = new ArrayList<>(3);
        objects.add(1);
        objects.add(2);
        objects.add(1);
        res.add(objects);
        if (numRows == 3) {
            return res;
        }
        int count = 4;
        while (count <= numRows) {
            objects = new ArrayList<>(count);
            // 先做首和尾的处理
            objects.add(1);
            // 获取前一个数组
            List<Integer> prev = res.get(count - 2);
            for (int i = 1; i <= count - 2; i++) {
                int val = prev.get(i - 1) + prev.get(i);
                objects.add(i, val);
            }
            objects.add(1);
            count++;
            res.add(objects);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(generate(5));
//        System.out.println(getRow(3));
        System.out.println(getRow(0));
    }
}
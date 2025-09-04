package org.newrain.problems.newcoder;

import java.util.ArrayList;

public class BM55 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param num int整型一维数组
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(num, res, new ArrayList<>(), new boolean[num.length]);
        return res;
    }


    public static void backtrack(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, boolean[] used) {
        if (path.size() == num.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(num[i]);
            used[i] = true;
            backtrack(num, res, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
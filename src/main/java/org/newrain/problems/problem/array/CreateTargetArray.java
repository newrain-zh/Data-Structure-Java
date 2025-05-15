package org.newrain.problems.problem.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 题目：按既定顺序创建目标数组
 *
 *
 */
public class CreateTargetArray {


    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0,1,2,2,1});
    }

}
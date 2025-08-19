package org.newrain.problems.problem.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindNumsAppearOnce {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    public static int[] FindNumsAppearOnce(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[]        ans      = new int[2];
        boolean      isFirst  = false;
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            if (map.get(integer) == 1) {
                if (!isFirst) {
                    ans[0] = integer;
                             isFirst = true;
                } else {
                    ans[1] = integer;
                }
            }
        }
        if (ans[1] < ans[0]) {
            int temp = ans[1];
            ans[1] = ans[0];
            ans[0] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = FindNumsAppearOnce(new int[]{1, 4, 1, 6});
        System.out.println(ints[0] + "," + ints[1]);

    }
}
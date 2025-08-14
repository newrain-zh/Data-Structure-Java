package org.newrain.problems.problem.array;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int MoreThanHalfNum_Solution(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        Map<Integer, Integer> map = new HashMap<>(numbers.length - 1);
        for (int number : numbers) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
                if (map.get(number) > numbers.length / 2) {
                    return number;
                }
            } else {
                map.put(number, 1);
            }
        }
        return -1;
    }
}
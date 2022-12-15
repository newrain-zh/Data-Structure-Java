package org.newrain.code.problem.array;

/**
 * @author NewRain
 * @description 只出现一次的数字
 */
public class SingleNumber {


    /**
     * @param a: An integer array
     * @return An integer
     */
    public int singleNumber(int[] a) {
        int single = 0;
        for (int num : a) {
            single ^= num;
        }
        return single;
    }
}
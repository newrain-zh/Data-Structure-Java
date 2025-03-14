package org.newrain.problems.problem.array;

public class MaxOfArray {

    /**
     * @param a: an array of float numbers
     * @return: a float number
     */
    public float maxOfArray(float[] a) {
        //设置为负无穷大
        float result = Float.NEGATIVE_INFINITY;
        for (float v : a) {
            result = Math.max(result, v);
        }
        return result;
    }
}
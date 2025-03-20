package org.newrain.problems.problem.math;


/**
 * LeetCode.492 构造矩形
 */
public class LeetCode492 {


    /**
     * 要求 L >= W
     * 长度 L 和宽度 W 之间的差距应当尽可能小。
     * L * W = area 且 L >= W
     * W * W <= L * W 推导出 W <= L√area
     */
    public int[] constructRectangle(int area) {
        int W = (int) Math.sqrt(area);
        while (area % W != 0) {
            W--;
        }
        return new int[]{area / W, W};
    }


}
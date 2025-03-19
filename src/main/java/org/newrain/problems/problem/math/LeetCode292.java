package org.newrain.problems.problem.math;

/**
 * 292. Nim 游戏
 */
public class LeetCode292 {

    /**
     * 决胜的关键在于最后的 4 粒石子
     * n%4 !=0 true 先手必胜
     * n%4 ==0 false 先手必败
     * <p>
     * 如果是 4 的整数倍
     * a: 无论先拿多少 b只要在 a的基础上拿到 4 的倍数
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
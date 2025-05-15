package org.newrain.problems.problem.recursive;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/elimination-game/">...</a>
 */
public class LeetCode390 {

    /**
     * 解题思路
     * 无论从左到右，还是从右到左 都是一次构建等差数列的过程
     * <p>
     * 情况一：剩余元素为奇数
     * <p>
     * 操作后的起始值变化：第一个被删除的是最右侧元素，导致剩余数组的起始值向右移动 step。
     * <p>
     * 示例：remaining = 5（数组 [a, b, c, d, e]）
     * <p>
     * 删除顺序：e → c → a
     * <p>
     * 剩余数组：[b, d]
     * <p>
     * 新起始值：原第二个元素 b，相当于原起始值 a 加上 step。
     * <p>
     * 情况二：剩余元素为偶数
     * <p>
     * 操作后的起始值不变：删除操作不影响起始位置。
     * <p>
     * 示例：remaining = 4（数组 [a, b, c, d]）
     * <p>
     * 删除顺序：d → b
     * <p>
     * 剩余数组：[a, c]
     * <p>
     * 新起始值：仍为原第一个元素 a。
     *
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        int remaining = n; // 剩余的元素
        int step = 1; // 间隔 每次删除操作，都会构建一个新的等差数列，间隔也会为 2*step
        int start = 1; // 初始等差值
        boolean leftToRight = true;
        while (remaining > 1) {
            if (leftToRight) {  // 从左到右删除 差值增加
                start += step;
            } else {  // 从右向左删除
                if (remaining % 2 == 1) { // 奇数的时候 ，起始值会改变
                    start += step;
                }
            }
            remaining /= 2; // 每次删除一半元素
            step *= 2; // 每次间隔翻倍
            leftToRight = !leftToRight; // 改变方向
        }
        return start;
    }

    public int lastRemaining1(int n) {
        return foreach(n, 1, true, 1);
    }

    public int foreach(int remaining, int start, boolean leftToRight, int step) {
        if (remaining <= 1) {
            return start;
        }
        int newRemaining = remaining;
        int newStep = step;
        int newStart = start;
        if (leftToRight) { // 从左到右删除
            newStart += step;
        } else {
            if (remaining % 2 == 1) {
                newStart += step;
            }
        }
        newRemaining /= 2;
        newStep *= 2;
        leftToRight = !leftToRight;
        return foreach(newRemaining, newStart, leftToRight, newStep);
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode390().lastRemaining1(9));
        System.out.println(new LeetCode390().lastRemaining1(1));
    }

}
package org.newrain.code.problem.base;

/**
 * leetcode.476 数字的补数
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 */
public class FindComplement {

    /**
     * 数学思路解法
     * <p>
     * 首先，我们需要确定给定整数 num 的二进制表示的位数。可以使用对数运算来计算，
     * 即 numBits = (int) (Math.log(num) / Math.log(2)) + 1。
     * 这里使用对数的换底公式，以 2 为底计算 num 的对数，
     * 然后将结果向上取整并加 1，得到二进制表示的位数。
     * <p>
     * 接下来，我们构造一个掩码 mask，它的位数与 num 相同，并且所有位都是 1。
     * 可以通过左移和减一运算得到掩码，即 mask = (1 << numBits) - 1。
     * <p>
     * 最后，我们对 num 进行取反操作，可以使用按位异或运算实现，即 complement = num ^ mask。
     * <p>
     * 返回取反后的结果 complement。
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        if (num == 0) return 0;
        // 计算 num 的二进制表示的位数
        int numBits = (int) (Math.log(num) / Math.log(2)) + 1;
        // 构造一个掩码，全为1且位数与 num 相同
        int mask = (1 << numBits) - 1;
        // 对 num 进行取反操作，通过按位异或运算实现
        return num ^ mask;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(Integer.toBinaryString((1 << 3) - 1));
    }
}
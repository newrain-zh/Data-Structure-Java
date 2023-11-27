package org.newrain.code.problem.array;


/**
 * 题目：leetcode.1287. 有序数组中出现次数超过25%的元素
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * @author alex
 * @description 有序数组中出现次数超过25%的元素
 * @link <a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/"></a>
 */
public class FindSpecialInteger {


    public static int findSpecialInteger(int[] arr) {
        int len = arr.length;
        if (len <= 2) {
            return arr[0];
        }
        int r = 0, l = 1;
        while (l < len) {
            if (arr[r] == arr[l]) {
                l++;
                continue;
            }
            if ((l - r) * 4 > len) {
                return arr[r];
            }
            r = l;
            l = r + 1;
        }
        if ((l - r) * 4 > len) {
            return arr[r];
        }
        return -1;
    }

    /**
     * 满足条件的整数 x 至少在数组 arr 中出现了 span = arr.length / 4 + 1 次，
     * 那么我们可以断定：数组 arr 中的元素 arr[0], arr[span], arr[span * 2], ... 一定包含 x。
     * <p>
     * 我们可以使用反证法证明上述的结论。假设 arr[0], arr[span], arr[span * 2], ... 均不为 x，
     * 由于数组 arr 已经有序，那么 x 只会连续地出现在 arr[0], arr[span], arr[span * 2], ... 中某两个相邻元素的间隔中，
     * 因此其出现的次数最多为 span - 1 次，这与它至少出现 span 次相矛盾。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/element-appearing-more-than-25-in-sorted-array/solution/you-xu-shu-zu-zhong-chu-xian-ci-shu-chao-guo-25d-3/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public static int findSpecialInteger1(int[] arr) {
        for (int i = 0, len = arr.length / 4; i < arr.length - len; i++) {
            if (arr[i] == arr[i + len]) {
                return arr[i];
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
        System.out.println(findSpecialInteger(new int[]{1, 2, 3, 3}));

    }
}
package org.newrain.code.problem.array;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素
 * 。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author newrain
 */
public class LeetCode169 {

    public static int majorityElement(int[] nums) {
        int cardNum = nums[0], count = 0;
        for (int num : nums) {
            if (count == 0) {
                cardNum = num;
            }
            if (num == cardNum) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return cardNum;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }


}

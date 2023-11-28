package org.newrain.code.problem.array;

/**
 * 题目：leetcode.2154. 将找到的值乘以2
 * 给你一个整数数组 nums ，另给你一个整数 original ，这是需要在 nums 中搜索的第一个数字。
 * 接下来，你需要按下述步骤操作：
 * <p>
 * 如果在 nums 中找到 original ，将 original 乘以 2 ，得到新 original（即，令 original = 2 * original）。
 * 否则，停止这一过程。
 * 只要能在数组中找到新 original ，就对新 original 继续 重复 这一过程。
 * 返回 original 的 最终 值。
 */
public class FindFinalValue {

    /**
     * 常规解法
     *
     * @param nums
     * @param original
     * @return
     */
    public static int findFinalValue(int[] nums, int original) {
        //第一步先遍历集合查询
        boolean has = false;
        for (int num : nums) {
            if (num == original) {
                has = true;
                break;
            }
        }
        if (!has) {
            return original;
        }
        while (has) {
            original *= 2;
            int len = 0;
            for (int num : nums) {
                if (original == num) {
                    break;
                } else {
                    len++;
                }
            }
            if (len == nums.length) {
                has = false;
            }
        }
        return original;
    }

    /**
     * 针对上述常规解法的代码优化
     *
     * @param nums
     * @param original
     * @return
     */
    public static int findFinalValue2(int[] nums, int original) {
        boolean has = true;
        while (has) {
            boolean currentHas = false;
            for (int num : nums) {
                if (original == num) {
                    original *= 2;
                    currentHas = true;
                    break;
                }
            }
            if (!currentHas) {
                has = false;
            }
        }
        return original;
    }

    /**
     * 递归解法
     *
     * @param nums
     * @param original
     * @return
     */
    public static int findFinalValue1(int[] nums, int original) {
        for (int num : nums) {
            if (num == original) {
                return findFinalValue1(nums, original * 2);
            }
        }
        return original;
    }


    public static void main(String[] args) {
        System.out.println(findFinalValue2(new int[]{5, 3, 6, 1, 12}, 3));
    }

}
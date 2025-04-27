package org.newrain.problems.problem.array;

/**
 * 删除数组重复元素
 */
public class LeetCode26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // i 指向去重后的最后一个元素

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++; // 找到新的唯一元素，移动 i
                nums[i] = nums[j]; // 将新的元素放到 i+1 的位置
            }
        }

        return i + 1; // i 是下标，所以数量要 +1
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
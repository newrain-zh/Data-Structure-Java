package org.newrain.problems.problem.array;

/**
 * LeetCode.11 盛最多的水
 */
public class LeetCode11 {


    /**
     * 容器的容量有两个决定因素，
     * 1. 两个元素之间的距离（宽度）
     * 2. 两个元素的高度
     * 面积= min(height[i],height[j]) * j-i
     * 题目本质是找到足够远的大值相近的两个数
     */
    public static int maxArea(int[] height) {
        int ans = 0;
        int maxHeight = -1;
        for (int i = 0; i < height.length; i++) {
            // 避免重复计算 这里属于优化 因为前面高的已经计算过了到数组后面的值的容量，那比它低的自然就不用再次计算了
            // 例如 1, 8, 6, 2, 5, 4, 8, 3, 7
            // 8 计算和后面所有元素的容积，那 6这个元素比 8 小，它再计算也没意义，因为它的容积不会再比前面这个 8 这个元素所能组成的容积更大
            if (height[i] <= maxHeight) maxHeight = height[i];
            for (int j = i + 1; j < height.length; j++) {
                int w = j - i; // 当前的宽度
                int h = Math.min(height[i], height[j]);
                System.out.println("i=" + i + "容量=" + (w * h));
                ans = Math.max(w * h, ans);
            }
            System.out.println("i=" + i + ",ans=" + ans);
        }
        return ans;
    }

    public static int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0; // 记录最大面积
        while (left < right) {
            int currHeight = Math.min(height[left], height[right]); // 获取当前最矮的那个高度
            maxArea = Math.max(currHeight * (right - left), maxArea);
            if (height[left] > height[right]) { // 矮的那一方向左 或向右运动
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }


    public static int maxArea2(int[] height) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
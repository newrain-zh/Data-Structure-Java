package org.newrain.problems.problem.array;

import java.util.Arrays;
import java.util.Stack;


/**
 * 每日温度
 */
public class LCR038 {

    /**
     * 超时
     *
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        int   n   = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }


    public static int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int            n     = temperatures.length;
        int[]          ans   = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer pop = stack.pop();
                ans[pop] = i - pop;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }


    public static int[] dailyTemperatures2(int[] temperatures) {
        int   n   = temperatures.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1; // 下一天
            while (j < n) {
                if (temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                } else if (ans[j] == 0) {
                    break;
                } else {
                    j += ans[j]; // 跳跃到 下一天更热的天数上
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});// 1,1,4,2,1,1,0,0
        System.out.println(Arrays.toString(ints));
    }
}
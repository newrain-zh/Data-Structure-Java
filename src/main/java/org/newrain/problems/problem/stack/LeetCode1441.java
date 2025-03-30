package org.newrain.problems.problem.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode.1441 用栈操作构建数组
 */
public class LeetCode1441 {


    public static List<String> buildArray(int[] target, int n) {

        List<String> res  = new ArrayList<>();
        int          i    = 0;
        int          step = 1;
        while (step <= target[target.length - 1]) {
            if (step == target[i]) {
                res.add("Push");
                if (i == target.length - 1) {
                    break;
                }
                step++;
                i++;
            } else {
                res.add("Push");
                res.add("Pop");
                step++;
            }
        }
        return res;
    }

    public static List<String> buildArray1(int[] target, int n) {

        List<String> res   = new ArrayList<>();
        int          index = 0;
        for (int i = 1; i <= n; i++) {
            if (index == target.length) {
                break;
            }
            if (i == target[index]) {
                index++;
                res.add("Push");
            } else {
                res.add("Push");
                res.add("Pop");
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(buildArray1(new int[]{2, 3, 4}, 4)); // ["Push","Pop","Push","Push","Push"]
//        System.out.println(buildArray1(new int[]{1, 2, 3}, 3));
    }
}
package org.newrain.problems.problem.array;

import java.util.HashMap;
import java.util.Map;


/**
 * leetcode.2011. 执行操作后的变量值
 * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
 * ++X 和 X++ 使变量 X 的值 加 1
 * --X 和 X-- 使变量 X 的值 减 1
 * 最初，X 的值是 0
 *
 * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
 * 示例 1：
 * 输入：operations = ["--X","X++","X++"]
 * 输出：1
 * 解释：操作按下述步骤执行：
 * 最初，X = 0
 * --X：X 减 1 ，X =  0 - 1 = -1
 * X++：X 加 1 ，X = -1 + 1 =  0
 * X++：X 加 1 ，X =  0 + 1 =  1
 */
public class FinalValueAfterOperations {

    /**
     * 更优的做法是直接遍历  有+号直接ans++ 否则res--
     * @param operations
     * @return
     */
    public static int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        Map<String, Integer> count = new HashMap<>(2);
        for (String operation : operations) {
            if ("++X".equals(operation) || "X++".equals(operation)) {
                count.put("+", count.getOrDefault("+", 0) + 1);
            } else {
                count.put("-", count.getOrDefault("-", 0) + 1);
            }
        }
        ans += count.getOrDefault("+", 0);
        ans -= count.getOrDefault("-", 0);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
    }
}
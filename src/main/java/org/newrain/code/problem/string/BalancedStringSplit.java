package org.newrain.code.problem.string;

/**
 * @author NewRain
 * @description 分割平衡字符串
 * @link <a href="https://leetcode.cn/problems/split-a-string-in-balanced-strings/"></a>
 * @tag string
 */
public class BalancedStringSplit {

    /**
     * 抵消思路
     * 字符只会出现以下几种情况
     * RL RRXXXLL LR LLXXXRR
     * 题目中LR都为成对出现 利用抵消思路来计算最大数量
     *
     * @param s
     * @return
     */
    public static int balancedStringSplit(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int cnt = 0, ans = 0;
        for (int i = 0; i < length; i++) {
            //cnt += chars[i] == 'L' ? 1 : -1;
            if (chars[i] == 'L') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
    }
}
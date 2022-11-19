package org.newrain.leetcode.problem.string;

/**
 * @author newRain
 * @description  连续字符
 * @link <a href="https://leetcode.cn/problems/consecutive-characters/"></a>
 */
public class LeetCode1446 {

    public static int maxPower(String s) {
        char[] chars = s.toCharArray();
        //必须考虑的特殊情况
        int length = chars.length;
        if (length == 1) {
            return 1;
        }
        //cnt当前字符连续重复次数 maxLen = 重复字符串最大长度
        int cnt = 0, maxLen = 0;
        for (int i = 0; i < length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                cnt++;
            } else {
                cnt = 0;
            }
            maxLen = Math.max(maxLen, cnt + 1);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }

}

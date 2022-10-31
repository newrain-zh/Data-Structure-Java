package org.newrain.leetcode.problem.string;


/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/detect-capital">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode520 {


    public static boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int lowChars = 0;
        int indexUp = 0;
        int upWord = 0;
        for (int i = 0; i < chars.length; i++) {
            //小写
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowChars++;
            }
            //首字母大写
            if (i == 0 && chars[i] >= 'A' && chars[i] <= 'Z') {
                indexUp++;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                upWord++;
            }
        }
        if (lowChars == word.length()) {
            return true;
        }
        //首字母大写 其余全小写
        if (indexUp == 1 && lowChars == word.length() - 1) {
            return true;
        }
        return upWord == word.length();
    }

    public static void main(String[] args) {
        detectCapitalUse("g");
    }
}

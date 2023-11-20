package org.newrain.code.problem.array;

/**
 * 句子中的最多单词数
 */
public class MostWordsFound {


    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for (String sentence : sentences) {
            ans = Math.max(ans, sentence.split(" ").length);
        }
        return ans;
    }

    /**
     * 使用该方法也可以统计出单词数
     * @param str
     * @return
     */
    public static int search(String str) {
        char[] charArray = str.toCharArray();
        int cnt = 0;
        for (char c : charArray) {
            if (c == ' ') {
                cnt++;
            }
        }
        return cnt + 1;

    }


}
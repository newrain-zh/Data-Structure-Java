package org.newrain.code.problem.array;

/**
 * 面试题 10.05. 稀疏数组搜索
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 * 示例1:
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 */
public class FindString {

    public int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * TODO 待补充二分查找
     * @param words
     * @param s
     * @return
     */
    public int findString1(String[] words, String s) {

        return 0;
    }
}
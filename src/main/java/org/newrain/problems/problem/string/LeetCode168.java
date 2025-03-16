package org.newrain.problems.problem.string;

/**
 * 168. Excel 表列名称
 */
public class LeetCode168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return String.valueOf((char) ('A' + columnNumber - 1));
        }
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            int a0 = (columnNumber - 1) % 26 + 1;
            res.append((char) (a0 - 1 + 'A'));
            columnNumber = (columnNumber - a0) / 26;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode168 leetCode168 = new LeetCode168();
        System.out.println(leetCode168.convertToTitle(701));
    }
}
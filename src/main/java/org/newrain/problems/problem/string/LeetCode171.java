package org.newrain.problems.problem.string;

/**
 * LeetCode.171. Excel 表列序号
 * https://leetcode.cn/problems/excel-sheet-column-number/
 */
public class LeetCode171 {

    /**
     * AA = 27  换算成 A (1*26) + A(1) = 27
     * <p>
     * ZY = 701 换算成 Z (26*26) + Y(25)
     *
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {
        int res = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            int num = columnTitle.charAt(i) - 'A' + 1;
            res = res * 26 + num; // num = 字母 - ‘A’ + 1
            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
        System.out.println(26 * 26 + 25);
    }
}
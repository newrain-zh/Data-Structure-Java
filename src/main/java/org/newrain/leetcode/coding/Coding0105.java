package org.newrain.leetcode.coding;

/**
 * 字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
 * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * @author newRain
 * @description 一次编辑
 * @link <a href="https://leetcode.cn/problems/one-away-lcci"></a>
 */
public class Coding0105 {

    /**
     * 双指针逐个比对
     * r=0    i s l a n d e r   first
     * l=0    s l a n d e r second
     * diff = 1 说明 first.length > second.length
     * 此时 second 可以考虑添加一个字符串
     * l-- 循环有l++操作 此时l保持原位不动 下次循环 r = 1
     * r=1    i [s l a n d e r]   first
     * l=0    [s l a n d e r] second
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        }
        int diff = first.length() - second.length();
        if (diff > 1 || diff < -1) {
            return false;
        }
        int chance = 1;
        for (int r = 0, l = 0; r < first.length() && l < second.length(); r++, l++) {
            if (first.charAt(r) != second.charAt(l)) {
                //first.length > second.length  second要不要添加一个字符
                if (diff == 1) {
                    l--;
                }
                //first.length < second.length  second要不要删除一个字符
                else if (diff == -1) {
                    r--;
                }
                chance--;
            }
            if (chance < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(oneEditAway("teacher", "treacher"));
        System.out.println(oneEditAway("islander", "slander"));
    }
}

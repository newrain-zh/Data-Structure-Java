package org.newrain.problems.problem.string;

/**
 * @author NewRain
 * @description 能否转换
 * @link <a href="https://www.lintcode.com/problem/1540">lintcode</a>
 */
public class CanConvert {

    /**
     * @param s: string S
     * @param t: string T
     * @return whether S can convert to T
     */
    public boolean canConvert(String s, String t) {
        if (s == null) {
            return false;
        }
        //包含字符串
        if (s.contains(t)) {
            return true;
        }
        if (t.length() > s.length()) {
            return false;
        }
        int n = s.length(), m = t.length();
        int l = 0, r = 0;
        //左右指针开始遍历两个字符串
        while (l < n && r < m) {
            if (s.charAt(l) == t.charAt(r)) {
                r++;
            }
            l++;
        }
        //如果遍历结束r=t.length 说明字符串s包含了字符串t出现的所有字符串
        return r == m;

    }
}
package org.newrain.problems.problem.array;

import java.util.Arrays;

/**
 * LeetCode.455 分发饼干
 */
public class LeetCode455 {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int l = 0, r = 0;
        while (l < g.length && r < s.length) {
            if (s[r] >= g[l]) {
                ans++;
                l++;
            }
            r++;

        }
        return ans;
    }


    public static int findContentChildren1(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int r = 0;
        for (int i = 0; i < g.length; i++) {
            while (r <= s.length - 1) { // 查找剩余的饼干数组中大于当前胃口的
                if (s[r] >= g[i]) {
                    ans++;
                    r++; // 饼干调整到下一个
                    break;
                }
                r++;
            }
            if (r > s.length - 1) { // 如果饼干数组遍历完则结束
                break;
            }
        }
        return ans;
    }

    public int findContentChildren3(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        int idx = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (idx >= 0 && s[idx] >= g[i]) {
                cnt++;
                idx--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren1(new int[]{1, 2, 3}, new int[]{3}));
        System.out.println(findContentChildren1(new int[]{1, 2, 3}, new int[]{1, 1}));
        System.out.println(findContentChildren1(new int[]{7, 8, 9, 10}, new int[]{5, 6, 7, 8}));
    }
}
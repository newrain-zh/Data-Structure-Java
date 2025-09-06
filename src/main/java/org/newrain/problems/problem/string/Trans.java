package org.newrain.problems.problem.string;

public class Trans {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @param n int整型
     * @return string字符串
     */
    public static String trans(String s, int n) {
        if (s == null || s.isEmpty()) return s;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) <= 'z' && s.charAt(i) >= 'a') || (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')) {
                char c = s.charAt(i);
                ret.append(c ^= 32);
            } else {
                ret.append(" ");
            }
        }
        String[] s1 = ret.toString().split(" ");
        int      l  = 0, r = s1.length - 1;
        while (l < r) {
            String temp = s1[l];
            s1[l] = s1[r];
            s1[r] = temp;
            l++;
            r--;
        }
        String join = String.join(" ", s1);
        if (String.valueOf(s.indexOf(0)).equals(" ")) {
            join = join + " ";
        }
        if (String.valueOf(s.charAt(s.length() - 1)).equals(" ")) {
            join = " " + join;

        }
        return join;
    }

    public static void main(String[] args) {
//        System.out.println(trans("This is a sample", 16));
        System.out.println(trans("h i ", 4));
    }
}
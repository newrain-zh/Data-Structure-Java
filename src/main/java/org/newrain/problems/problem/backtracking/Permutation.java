package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    private List<String> ans = new ArrayList<>();

    public String[] permutation(String S) {
        backtracking(new boolean[S.length()], "", S.toCharArray());
        if (!ans.isEmpty()) {
            String[] res = new String[ans.size()];
            for (int i = 0; i < ans.size(); i++) {
                res[i] = ans.get(i);
            }
            return res;
        }
        return new String[0];
    }


    public void backtracking(boolean[] used, String path, char[] chars) {
        if (path.length() == chars.length) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path += chars[i];
                backtracking(used, path, chars);
                used[i] = false;
                path    = path.substring(0, path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation().permutation("qwe")));
        System.out.println(Arrays.toString(new Permutation().permutation("ab")));

    }

}
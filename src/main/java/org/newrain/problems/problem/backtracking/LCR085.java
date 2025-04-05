package org.newrain.problems.problem.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LCR085 括号生成
 */
public class LCR085 {

    List<String> ans = new ArrayList<>();
    int          n   = 0;


    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtracking(0, 0, "");
        return ans;
    }

    public void backtracking(int l, int r, String path) {
        if (l > n || r > l) { // 剪枝
            return;
        }
        if (path.length() == n * 2) {
            ans.add(path);
            return;
        }
        backtracking(l + 1, r, path + "(");
        backtracking(l, r + 1, path + ")");
    }

    public static void main(String[] args) {
//        List<String> strings = new LCR85().generateParenthesis(3);
        List<String> strings = new LCR085().generateParenthesisTest(2);
        System.out.println(strings);

    }

    /*
     * n = 2 树形递归展示
     *              ""
     *            ↙
     *          (   ( + ())
     *        ↙    ↗
     *      ((  (( + )(
     *      ↙  ↗
     *    ((( (((+ )
     *     ↙ ↗
     *   (((( 「path = 2*n 开始回溯」
     *
     *根节点: path = ""
        ├─ 分支1: path + "(" → "("
        │  ├─ 分支1: "(" + "(" → "(("
        │  │  ├─ 分支1: "((" + "(" → "(((" ❌（继续递归到长度4）
        │  │  └─ 分支2: "((" + ")" → "(()"
        │  │      ├─ 分支1: "(()" + "(" → "(()(" ❌
        │  │      └─ 分支2: "(()" + ")" → "(())" ✅（有效解）
        │  └─ 分支2: "(" + ")" → "()"
        │      ├─ 分支1: "()" + "(" → "()("
        │      │  ├─ 分支1: "()(" + "(" → "()((" ❌
        │      │  └─ 分支2: "()(" + ")" → "()()" ✅（有效解）
        │      └─ 分支2: "()" + ")" → "())"
        │          ├─ 分支1: "())" + "(" → "())(" ❌
        │          └─ 分支2: "())" + ")" → "()))" ❌
        └─ 分支2: path + ")" → ")"
           ├─ 分支1: ")" + "(" → ")("
           │  ├─ 分支1: ")(" + "(" → ")()"
           │  │  ├─ 分支1: ")()" + "(" → ")()(" ❌
           │  │  └─ 分支2: ")()" + ")" → ")())" ❌
           │  └─ 分支2: ")(" + ")" → "))"
           │      ├─ 分支1: "))" + "(" → "))(" ❌
           │      └─ 分支2: "))" + ")" → "))))" ❌
           └─ 分支2: ")" + ")" → "))"
               ├─ 分支1: "))" + "(" → "))(" ❌
               └─ 分支2: "))" + ")" → "))))" ❌
     *
     *
     */

    public void backtrackingTest(String path) {
        if (path.length() == n * 2) {
            ans.add(path);
            return;
        }
        backtrackingTest(path + "(");
        backtrackingTest(path + ")");
    }

    public List<String> generateParenthesisTest(int n) {
        this.n = n;
        backtrackingTest("");
        return ans;
    }
}
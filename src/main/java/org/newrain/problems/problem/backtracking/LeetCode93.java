package org.newrain.problems.problem.backtracking;

import java.util.*;

/**
 * 复原 IP 地址
 */
public class LeetCode93 {

    public List<String> ans = new ArrayList<>();

    List<String> temp = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0);
        return ans;
    }

    private void backtrack(String s, int start) {
        if (temp.size() == 4) {
            if (start == s.length()) {
                ans.add(String.join(".", temp));
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i + 1);
            if (isValid(str)) {
                temp.add(str);
                backtrack(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isValid(String str) {
        if (str.length() != 1 && str.charAt(0) == '0') {
            return false;
        }
        return Long.parseLong(str) <= 255L;
    }


    public static void main(String[] args) {
        List<String> strings = new LeetCode93().restoreIpAddresses("25525511135");
        System.out.println(Arrays.toString(strings.toArray()));

        System.out.println(restoreIpAddresses1("25525511135"));
    }


    /**
     * 广度优先遍历
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses1(String s) {
        List<String> res = new ArrayList<>();
        int          n   = s.length();

        // 边界判断
        if (n < 4 || n > 12) return res;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(new ArrayList<>(), 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 终止条件：恰好切了4段且遍历完字符串
            if (node.path.size() == 4 && node.index == n) {
                res.add(String.join(".", node.path));
                continue;
            }
            // 如果段数已经够了，或字符用完了，就不继续扩展
            if (node.path.size() >= 4 || node.index >= n) continue;
            // 尝试切1~3位
            for (int len = 1; len <= 3 && node.index + len <= n; len++) {
                String part = s.substring(node.index, node.index + len);
                if (isValid(part)) {
                    List<String> newPath = new ArrayList<>(node.path);
                    newPath.add(part);
                    queue.offer(new Node(newPath, node.index + len));
                }
            }
        }

        return res;


    }

    static class Node {
        List<String> path;
        int          index;

        public Node(List<String> path, int index) {
            this.path  = path;
            this.index = index;
        }
    }
}
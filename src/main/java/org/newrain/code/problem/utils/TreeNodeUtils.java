package org.newrain.code.problem.utils;

import org.newrain.code.problem.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {


    // 主构建方法（处理Integer数组）
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            TreeNode current = queue.poll();
            // 处理左子节点
            if (arr[index] != null) {
                current.left = new TreeNode(arr[index]);
                queue.add(current.left);
            }
            index++;

            // 处理右子节点
            if (index < arr.length && arr[index] != null) {
                current.right = new TreeNode(arr[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }


    public static void printTree(TreeNode root) {
        if (root == null) return;

        int maxDepth = getMaxDepth(root);
        int nodeWidth = 3; // 每个节点占3字符
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;

        while (!queue.isEmpty() && level <= maxDepth) {
            int levelNodes = queue.size();
            // 关键修复：动态缩进公式
            int indent = (int) (Math.pow(2, maxDepth - level) - 1) * nodeWidth;
            int spacing = (int) (Math.pow(2, maxDepth - level + 1) - 1) * nodeWidth;

            // 打印节点行
            printSpaces(indent);
            List<TreeNode> nextLevel = new ArrayList<>();
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.printf("%3d", node.val);
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                } else {
                    System.out.print("   ");
                    nextLevel.add(null);
                    nextLevel.add(null);
                }
                printSpaces(spacing);
            }
            System.out.println();

            // 打印连接线（优化对齐逻辑）
            if (level < maxDepth) {
                printSpaces(indent - nodeWidth / 2); // 精确缩进修正
                for (int i = 0; i < levelNodes; i++) {
                    // 左连接线（精确到父节点中心）
                    if (nextLevel.get(2 * i) != null) {
                        System.out.print(" /");
                    } else {
                        printSpaces(2);
                    }

                    // 右连接线（精确到父节点中心）
                    if (nextLevel.get(2 * i + 1) != null) {
                        System.out.print("\\ ");
                    } else {
                        printSpaces(2);
                    }
                    printSpaces(spacing - nodeWidth); // 动态间距修正
                }
                System.out.println();
            }

            queue.clear();
            queue.addAll(nextLevel);
            level++;
        }
    }

    // 辅助方法：计算树的最大深度
    private static int getMaxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getMaxDepth(node.left), getMaxDepth(node.right));
    }

    // 辅助方法：打印指定数量的空格
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void print(TreeNode root) {
        List<String> result = printNode(root);
        for (String line : result) {
            System.out.println(line);
        }
    }

    private static List<String> printNode(TreeNode node) {
        List<String> lines = new ArrayList<>();
        if (node == null) return lines;

        String current = String.valueOf(node.val);
        List<String> left = printNode(node.left);
        List<String> right = printNode(node.right);

        int maxLen = Math.max(current.length(), Math.max(left.isEmpty() ? 0 : left.get(0).length(), right.isEmpty() ? 0 : right.get(0).length()));

        // 构建当前节点行
        int padding = (maxLen - current.length() + 1) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) sb.append(" ");
        sb.append(current);
        for (int i = 0; i < padding; i++) sb.append(" ");
        lines.add(sb.toString());

        // 构建连接线
        if (!left.isEmpty() || !right.isEmpty()) {
            sb = new StringBuilder();
            int leftSpace = left.isEmpty() ? 0 : left.get(0).length() / 2;
            int rightSpace = right.isEmpty() ? 0 : right.get(0).length() / 2;

            if (!left.isEmpty()) {
                for (int i = 0; i < leftSpace; i++) sb.append(" ");
                sb.append("/");
                for (int i = leftSpace + 1; i < maxLen - rightSpace; i++) sb.append(" ");
            }

            if (!right.isEmpty()) {
                for (int i = 0; i < maxLen - rightSpace - leftSpace - 1; i++) sb.append(" ");
                sb.append("\\");
                for (int i = 0; i < rightSpace; i++) sb.append(" ");
            }
            lines.add(sb.toString());
        }

        // 合并子节点
        for (int i = 0; i < Math.max(left.size(), right.size()); i++) {
            String l = i < left.size() ? left.get(i) : "";
            String r = i < right.size() ? right.get(i) : "";
            lines.add(l + (l.isEmpty() || r.isEmpty() ? "" : " ") + r);
        }

        return lines;
    }

    public static void main(String[] args) {
        Integer[] arr = {7, 5, 1, 3, 10, 0, 2, null, null, 8, 15};
        TreeNode root = TreeNodeUtils.buildTree(arr);
        TreeNodeUtils.printTree(root);
    }

}
package org.newrain.problems.problem.utils;


import org.newrain.problems.problem.common.Node;

import java.util.LinkedList;
import java.util.Queue;


public class TreeUtils {

    /**
     * 根据层序数组生成二叉树（包含 null 值表示空节点）
     *
     * @param array 层序遍历的数组，例如 [1,2,3,null,5] 表示：
     *              1
     *              / \
     *              2   3
     *              \
     *              5
     * @return 二叉树的根节点
     */
    public static Node buildTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        Node root = new Node(array[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < array.length) {
            Node current = queue.poll();

            // 处理左子节点
            if (index < array.length && array[index] != null) {
                current.left = new Node(array[index]);
                queue.offer(current.left);
            }
            index++;

            // 处理右子节点
            if (index < array.length && array[index] != null) {
                current.right = new Node(array[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    /**
     * 可视化打印二叉树（树形结构）
     *
     * @param root 二叉树根节点
     */
    public static void printTree(Node root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }
        printTree(root, "", true);
    }

    private static void printTree(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            return;
        }

        // 打印当前节点
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);

        // 递归处理子节点
        String newPrefix = prefix + (isLeft ? "│   " : "    ");
        printTree(node.left, newPrefix, true);  // 左子树标记为左分支
        printTree(node.right, newPrefix, false); // 右子树标记为右分支
    }

    // 测试示例
    public static void main(String[] args) {
        // 示例数组 [1,2,3,null,5]
        Integer[] array = {1, 2, 3, null, 5};
        Node root = buildTree(array);
        printTree(root);

        /* 输出结果：
            ├── 1
            │   ├── 2
            │   │   └── 5
            │   └── 3
        */
    }
}
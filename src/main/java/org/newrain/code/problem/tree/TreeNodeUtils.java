package org.newrain.code.problem.tree;

public class TreeNodeUtils {

    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0);
    }

    private static TreeNode buildTree(Integer[] nums, int index) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        // 创建当前节点
        TreeNode node = new TreeNode(nums[index]);

        // 递归构建左子树和右子树
        node.left = buildTree(nums, 2 * index + 1);
        node.right = buildTree(nums, 2 * index + 2);

        return node;
    }

    public static void printTree(TreeNode root) {
        printTree(root, 0);

    }
    private static void printTree(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        // Print right child first (top-down approach)
        printTree(node.right, depth + 1);

        // Print spaces based on depth
        printSpaces(4 * depth);

        // Print node value
        System.out.print(node.val);

        // Print newline
        System.out.println();

        // Print left child
        printTree(node.left, depth + 1);
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

}
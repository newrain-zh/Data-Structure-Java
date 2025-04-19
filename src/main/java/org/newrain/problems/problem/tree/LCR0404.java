package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 检查树的平衡性
 */
public class LCR0404 {

    /*
       假设当前节点为 x,每个isBalanced(x) 调用了：
	•	height(x.left)
	•	height(x.right)
	•	isBalanced(x.left)
	•	isBalanced(x.right)
	    存在重复调用
	    这里的代码是从当前节点触发，递归判断它的左右子树高度，再次递归判断它的左右子树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h = Math.max(height(root.left), height(root.right)) + 1;
        System.out.println("node=" + root.val + ",height=" + h);
        return h;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new LCR0404().isBalanced(treeNode));
    }

    /**
     * 最优解法
     *
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node) {
        if (node == null) return 0;

        int left = dfsHeight(node.left);
        if (left == -1) return -1; // 剪枝

        int right = dfsHeight(node.right);
        if (right == -1) return -1; // 剪枝

        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

}
package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * @author NewRain
 * <a href="https://leetcode.cn/problems/NYBBNL/description/?envType=problem-list-v2&envId=nwEI8Rqc">...</a>
 */
public class LCR052 {

    TreeNode dummyNode = new TreeNode(-1);
    public TreeNode prev; // 保存上一节点

    public TreeNode increasingBST(TreeNode root) {
        // 将 prev 重置到 dummyNode 虚拟头节点
        // 这里要考虑引用传递的问题
        prev = dummyNode;
        TreeNode test = prev;
        inOrder(root);
        TreeNodeUtils.printTree(test);
        return dummyNode.right;
    }


    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = null; // 断开节点的左子树
        prev.right = node; // 前驱的右子 指向当前节点
        prev = node; // 更新前驱节点
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9};
//        Integer[] arr = new Integer[]{5, 1, 7};
        TreeNode treeNode = TreeNodeUtils.buildTree(arr);
        TreeNodeUtils.printTree(treeNode);
        System.out.println("====================");
        TreeNode res = new LCR052().increasingBST(treeNode);
        TreeNodeUtils.printTree(res);

    }


}
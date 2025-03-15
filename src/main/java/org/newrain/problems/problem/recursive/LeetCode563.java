package org.newrain.problems.problem.recursive;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *  二叉树的坡度
 *  <a href="https://leetcode.cn/problems/binary-tree-tilt/description/">...</a>
 * @author NewRain
 */
public class LeetCode563 {

    /**
     * 后序遍历
     * 将每层的坡度存入 List ，然后求和
     *
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        if (!list.isEmpty()) {
            int sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            return sum;
        }
        return 0;
    }

    public static int dfs(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return 0;
        }
        int leftVal = 0;
        if (treeNode.left != null) {
            leftVal = dfs(treeNode.left, list);
        }
        int rightVal = 0;
        if (treeNode.right != null) {
            rightVal = dfs(treeNode.right, list);
        }
        int abs = Math.abs(leftVal - rightVal);
        if (abs > 0) {
            list.add(abs);
        }
        System.out.println("当前节点:" + treeNode.val + " 左节点:" + leftVal + " 右节点:" + rightVal + " 坡度:" + Math.abs(leftVal - rightVal));
        return treeNode.val + leftVal + rightVal; // 返回当前节点和左右节点的相加值
    }

    public static void findTiltTest() {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{21, 7, 14, 1, 1, 2, 2, 3, 3});
        TreeNodeUtils.printTree(treeNode);
        System.out.println(new LeetCode563().findTilt(treeNode));
    }

    int ans = 0;

    /**
     * 上述解法的变种
     * 使用 ans 记录坡度
     *
     * @param root
     * @return
     */
    public int findTilt1(TreeNode root) {
        dfs1(root);
        return ans;
    }

    public int dfs1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftVal = 0;
        if (root.left != null) {
            leftVal = dfs1(root.left);
        }
        int rightVal = 0;
        if (root.right != null) {
            rightVal = dfs1(root.left);
        }
        ans += Math.abs(rightVal - leftVal);
        return leftVal + rightVal + root.val;
    }


    public static void main(String[] args) {
        findTiltTest();
    }
}
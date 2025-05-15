package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode. 872 叶子相似的树
 */
public class LeetCode872 {


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        dfs(root2, list2);
        if (list1.size() != list2.size()) {
            return false;
        }
        int size = list1.size();
        for (int i = 0; i < size; i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, list);
        dfs(treeNode.right, list);
        if (treeNode.right == null && treeNode.left == null) {
            list.add(treeNode.val);
        }
    }

    public static void main(String[] args) {
        LeetCode872 leetCode872 = new LeetCode872();
   /*     TreeNode    treeNode1   = TreeNodeUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4});
        TreeNode    treeNode2   = TreeNodeUtils.buildTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        System.out.println(leetCode872.leafSimilar(treeNode1, treeNode2));*/

        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 14});
        TreeNode treeNode2 = TreeNodeUtils.buildTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8});
        System.out.println(leetCode872.leafSimilar(treeNode1, treeNode2));

    }


}
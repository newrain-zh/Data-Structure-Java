package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

/**
 * 构造二叉搜索树
 */
public class SortedArrayToBST {


    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(0, nums.length - 1, nums);
    }

    /*
    buildTree(0,4) → 根=0
        ├─ buildTree(0,1) → 根=-10
        │  ├─ buildTree(0,-1) → null
        │  └─ buildTree(1,1) → 根=-3
        │     ├─ buildTree(1,0) → null
        │     └─ buildTree(2,1) → null
        └─ buildTree(3,4) → 根=5
           ├─ buildTree(3,2) → null
           └─ buildTree(4,4) → 根=9
              ├─ buildTree(4,3) → null
              └─ buildTree(5,4) → null
     */
    public TreeNode buildTree(int l, int r, int[] nums) {
        if (l > r) {
            return null;
        }
        int      mid      = l + (r - l) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left  = buildTree(l, mid - 1, nums);
        treeNode.right = buildTree(mid + 1, r, nums);
        return treeNode;
    }

    public static void main(String[] args) {
        SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
        TreeNode         treeNode         = sortedArrayToBST.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeNodeUtils.printTree(treeNode);
    }
}
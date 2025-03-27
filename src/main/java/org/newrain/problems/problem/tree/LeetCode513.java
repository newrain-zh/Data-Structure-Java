package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LeetCode.513 寻找最右下角的值
 */
public class LeetCode513 {


    public static int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        TreeNode lNode = root;
        int      lDeep = 0;
        while (lNode.left != null) {
            lDeep++;
            lNode = lNode.left;
        }
        if (root.right == null) { // 如果没有右子树
            return lNode.val;
        }

        TreeNode rNode = root.right;
        int      rDeep = 1;
        while (rNode.left != null) {
            rDeep++;
            rNode = rNode.left;
        }
        if (lDeep == 0) {
            return rNode.val;
        }
        if (lDeep > rDeep) {
            return lNode.val;
        } else if (lDeep < rDeep) {
            return rNode.val;
        }
        return lNode.val;
    }


    public static int findBottomLeftValue1(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int           size      = deque.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    continue;
                }
                levelList.add(poll.val);
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
            if (!levelList.isEmpty()) {
                list.add(levelList);
            }
        }
        return list.get(list.size() - 1).get(0);
    }

    /**
     * 在findBottomLeftValue1的方法优化了
     *
     * @param root
     * @return
     */
    public static int findBottomLeftValue2(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int ans = -1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    continue;
                }
                if (i == 0) {
                    ans = poll.val;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return ans;
    }


    public int findBottomLeftValue3(TreeNode root) {
        TreeNode[] treeNodes = new TreeNode[1];
        dfs(root, 0, treeNodes);
        return treeNodes[0].val;
    }

    int maxDeep = -1; // 记录最大深度

    /**
     * 要找到最右下角的值 目标值只会在最后一行
     * 所以要找到 maxDeep 最大的 就可以
     *
     * @param treeNode
     * @param level
     * @param ans
     */

    public void dfs(TreeNode treeNode, int level, TreeNode[] ans) {
        if (treeNode == null) {
            return;
        }
        dfs(treeNode.left, level + 1, ans);
        dfs(treeNode.right, level + 1, ans);
        if (level > maxDeep) { // maxDeep最大值 更新 ans
            maxDeep = level;
            ans[0]  = treeNode;
        }

    }


    public int findBottomLeftValue4(TreeNode root) {
        TreeNode[] treeNodes = new TreeNode[1];
        dfs(root, 0, treeNodes);
        return treeNodes[0].val;
    }

    int maxDepth = -1;
    int ans      = 0;

    public void dfs1(TreeNode treeNode, int level) {
        if (treeNode == null) {
            return;
        }
        dfs1(treeNode.left, level + 1);
        dfs1(treeNode.right, level + 1);
        if (level > maxDeep) {
            maxDepth = level;
            ans      = treeNode.val;
        }

    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7});
    /*    System.out.println(findBottomLeftValue2(treeNode));
        TreeNode treeNode2 = TreeNodeUtils.buildTree(new Integer[]{3, 1, 5, 0, 2, 4, 6, null, null, null, 3});
        System.out.println(findBottomLeftValue2(treeNode2));*/
        LeetCode513 leetCode513 = new LeetCode513();
        TreeNode[]  treeNodes   = new TreeNode[1];
        leetCode513.dfs(treeNode, 0, treeNodes);
        System.out.println();


    }

}
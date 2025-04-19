package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 寻找 target
 */
public class LCR050 {

    /*
        private int targetSum;

        private int ans = 0;

        public int pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            dfs(root, 0);
            return ans;
        }

        *//*
        ❌错误解法
     *//*
    public void dfs(TreeNode treeNode, int sum) {
        System.out.println("sum=" + sum);
        if (treeNode == null) {
            return;
        }
        int currSum = 0;
        if (sum + treeNode.val < targetSum) {
            currSum = sum + treeNode.val;
        } else if (sum + treeNode.val == targetSum) {
            ans++;
            currSum = treeNode.val;
        }
        dfs(treeNode.left, currSum);
        dfs(treeNode.right, currSum);

    }*/
    /*
    不会重复，是因为每次尝试的起点不同，路径都是“从当前节点往下”，不会重复计算“起点一样，路径一样”的组合。
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        return countPaths(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int countPaths(TreeNode node, long target) {
        if (node == null) return 0;

        int count = 0;
        if (node.val == target) count++;

        count += countPaths(node.left, target - node.val);
        count += countPaths(node.right, target - node.val);
        return count;
    }


    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});  // target = 8 // 3
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{715827882,715827882,null,715827882,null,1,null,715827882,null,715827882,null,715827882,null});  // target = 8 // 3
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}); //3
        LCR050 lcr050 = new LCR050();
        System.out.println(lcr050.pathSum1(treeNode, 8));
    }


    public int pathSum1(TreeNode root, int targetSum) {
        backtrack(root, targetSum, new ArrayList<>());
        return ans;
    }

    private int ans = 0;

    public void backtrack(TreeNode treeNode, int targetSum, List<Integer> path) {
        if (treeNode == null) return;

        path.add(treeNode.val); // 添加当前节点

        /*
            从当前路径向上累加，判断是否有子路径等于 targetSum
          这里是倒序遍历，因为 path路径是从根节点出发，最后面的元素肯定是子节点，由子节点向上寻找，(因为回溯时子节点不短变化)
               10
             /
            5
           /
          3
        路径可以从任意节点开始，到任意节点结束，只要方向是“从父到子”就行
        以当前节点为终点
        path [10,5,3] target = 8
        倒序遍历 [3] [3,5,10] [5,10]
        正序遍历 [10] [10,5] [10,5,3] 漏掉了 5->3 始终都是从根节点从发去找 target =8
        如果需要正序遍历解决呢？ 那就是要找某一段合法路径 target=8
        @See backtrack1

         */
        long sum = 0;
        System.out.println(Arrays.toString(path.toArray()));
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) {
                ans++;
            }
        }

        backtrack(treeNode.left, targetSum, path);
        backtrack(treeNode.right, targetSum, path);

        path.remove(path.size() - 1);

    }

    public void backtrack1(TreeNode treeNode, int targetSum, List<Integer> path) {
        if (treeNode == null) return;

        path.add(treeNode.val); // 添加当前节点

        for (int i = 0; i < path.size(); i++) {
            int sum = 0;
            for (int j = i; j < path.size(); j++) {
                sum += path.get(j);
                if (sum == targetSum) {
                    ans++;
                }
            }
        }

        backtrack1(treeNode.left, targetSum, path);
        backtrack1(treeNode.right, targetSum, path);
        path.remove(path.size() - 1);

    }


}
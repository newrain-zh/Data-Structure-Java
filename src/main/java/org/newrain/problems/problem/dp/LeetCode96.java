package org.newrain.problems.problem.dp;

/**
 * 96. 不同的二叉搜索树
 */
public class LeetCode96 {
    /**
     * 二叉搜索树的要满足以下特点
     * 1. 左子树小于根节点
     * 2. 右节点大于根节点
     * 3. 每个子树也满足以上两点
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1]; // 存储为各个数字能构建搜索BST的数量
        dp[0] = 1; // 空树
        dp[1] = 1; // 单节点
        for (int i = 2; i <= n; i++) { // 以 i 做为根节点
/*            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }*/
            int j = 1;  // 每次都需要从根节点为 1 开始算起
            while (j <= i) { //
                // dp[j-1] 表示当前根节点的左子树的节点个数组成二叉树的数量
                // dp[i-j] 表示当前根节点的右子树的节点个数组成二叉树的数量
                dp[i] += dp[j - 1] * dp[i - j];
                j++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
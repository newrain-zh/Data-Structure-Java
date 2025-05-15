package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * LCR 046. 二叉树的右视图
 */
public class LCR046 {


    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        List<Integer> ans = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll == null) {
                    continue;
                }
                if (i == 0) {
                    ans.add(poll.val);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
            }
        }
        return ans;
    }

    /**
     * 第二种解法
     */

    //层次遍历、递归遍历
    private List<Integer> ret = new ArrayList<>();
    private int depth = 0;
    public List<Integer> rightSideView1(TreeNode root) {
        if(root==null)return ret;
        trivaser(root);
        return ret;

    }
    private void trivaser(TreeNode node){
        if(node==null)return;
        depth++;
        if(depth>ret.size()){
            //第一次访问这个深度
            ret.add(node.val);
        }
        //遍历右孩子和左孩子
        trivaser(node.right);
        trivaser(node.left);
        depth--;

    }

    public static void main(String[] args) {
//        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        TreeNode treeNode = TreeNodeUtils.buildTree(new Integer[]{1, null, 3});
        System.out.println(new LCR046().rightSideView(treeNode));
    }


}
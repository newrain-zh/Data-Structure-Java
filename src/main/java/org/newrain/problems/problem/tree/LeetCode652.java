package org.newrain.problems.problem.tree;

import org.newrain.problems.problem.common.TreeNode;
import org.newrain.problems.problem.utils.TreeNodeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 寻找重复的子树
 */
public class LeetCode652 {


    private Map<String, Integer> serialCount = new HashMap<>();
    private List<TreeNode>       result      = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null) return "#";
        String left = serialize(node.left);
        String right = serialize(node.right);
        String current = left + "," + right + "," + node.val;
        int count = serialCount.getOrDefault(current, 0);
        serialCount.put(current, count + 1);
        if (count == 1) { // 当第二次出现时记录
            result.add(node);
        }
        System.out.println(current);
        return current;
    }



    private Map<String, Integer> tripletToId = new HashMap<>();
    private Map<Integer, Integer> idCount = new HashMap<>();
    private int currentId = 1;

    public List<TreeNode> findDuplicateSubtrees1(TreeNode root) {
        serialize1(root);
        return result;
    }

    private int serialize1(TreeNode node) {
        if (node == null) return 0;
        int leftId = serialize1(node.left);
        int rightId = serialize1(node.right);
        String triplet = leftId + "," + node.val + "," + rightId;
        if (!tripletToId.containsKey(triplet)) {
            tripletToId.put(triplet, currentId++);
        }
        System.out.println(triplet);
        int id = tripletToId.get(triplet);
        int count = idCount.getOrDefault(id, 0) + 1;
        idCount.put(id, count);
        if (count == 2) result.add(node);
        return id;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNodeUtils.buildTree(new Integer[]{1, 2, 3, 4, null, 2, 4, null, null, 4});
//        TreeNode treeNode  = TreeNodeUtils.buildTree(new Integer[]{2, 1, 1});
        new LeetCode652().findDuplicateSubtrees1(treeNode1);
    }
}
package org.newrain.code.problem.utils;

import org.newrain.code.problem.common.NTreeNode;

import java.util.*;

public class NTreeUtils {

    // 构建N叉树（反序列化）
    public static NTreeNode buildTree(List<Integer> data) {
        if (data == null || data.isEmpty() || data.get(0) == null) {
            return null;
        }
        Queue<Integer> inputQueue = new LinkedList<>(data);
        NTreeNode root = new NTreeNode(inputQueue.poll());
        inputQueue.poll(); // 移除根节点后的null分隔符

        Queue<NTreeNode> NTreeNodeQueue = new LinkedList<>();
        NTreeNodeQueue.offer(root);

        while (!inputQueue.isEmpty()) {
            NTreeNode current = NTreeNodeQueue.poll();
            List<NTreeNode> children = new ArrayList<>();
            while (!inputQueue.isEmpty() && inputQueue.peek() != null) {
                Integer val = inputQueue.poll();
                if (val != null) {
                    NTreeNode child = new NTreeNode(val);
                    children.add(child);
                    NTreeNodeQueue.offer(child);
                }
            }
            current.children = children;
            if (!inputQueue.isEmpty()) {
                inputQueue.poll(); // 移除null分隔符
            }
        }
        return root;
    }

    // 前序遍历
    public static List<Integer> preorder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(NTreeNode NTreeNode, List<Integer> result) {
        if (NTreeNode == null) return;
        result.add(NTreeNode.val);
        for (NTreeNode child : NTreeNode.children) {
            preorderHelper(child, result);
        }
    }

    // 后序遍历
    public static List<Integer> postorder(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(NTreeNode NTreeNode, List<Integer> result) {
        if (NTreeNode == null) return;
        for (NTreeNode child : NTreeNode.children) {
            postorderHelper(child, result);
        }
        result.add(NTreeNode.val);
    }

    // 层序遍历
    public static List<List<Integer>> levelOrder(NTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                NTreeNode NTreeNode = queue.poll();
                level.add(NTreeNode.val);
                queue.addAll(NTreeNode.children);
            }
            result.add(level);
        }
        return result;
    }

    // 查找节点
    public static NTreeNode findNode(NTreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        for (NTreeNode child : root.children) {
            NTreeNode found = findNode(child, target);
            if (found != null) return found;
        }
        return null;
    }

    // 计算树的高度
    public static int maxDepth(NTreeNode root) {
        if (root == null) return 0;
        int max = 0;
        for (NTreeNode child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    // 计算节点总数
    public static int countNodes(NTreeNode root) {
        if (root == null) return 0;
        int count = 1;
        for (NTreeNode child : root.children) {
            count += countNodes(child);
        }
        return count;
    }

    // 序列化N叉树
    public static List<Integer> serialize(NTreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<NTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        result.add(root.val);
        result.add(null); // 根节点子节点开始标记
        while (!queue.isEmpty()) {
            NTreeNode current = queue.poll();
            for (NTreeNode child : current.children) {
                result.add(child.val);
                queue.offer(child);
            }
            result.add(null); // 当前节点子节点结束标记
        }
        // 移除末尾多余的null
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }

    // 测试代码
    public static void main(String[] args) {
        // 示例：构建树 [1,null,3,2,4,null,5,6]
        List<Integer> data = Arrays.asList(1, null, 3, 2, 4, null, 5, 6);
        NTreeNode root = buildTree(data);

        // 前序遍历
        System.out.println("前序遍历: " + preorder(root));

        // 层序遍历
        System.out.println("层序遍历: " + levelOrder(root));

        // 查找节点
        System.out.println("查找节点5: " + (findNode(root, 5) != null ? "存在" : "不存在"));

        // 计算高度
        System.out.println("树的高度: " + maxDepth(root));

        // 序列化
        System.out.println("序列化结果: " + serialize(root));
    }
}
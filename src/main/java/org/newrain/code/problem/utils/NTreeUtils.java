package org.newrain.code.problem.utils;

import org.newrain.code.problem.common.Node;

import java.util.*;

public class NTreeUtils {

    // 构建N叉树（反序列化）
    public static Node buildTree(List<Integer> data) {
        if (data == null || data.isEmpty() || data.get(0) == null) {
            return null;
        }
        Queue<Integer> inputQueue = new LinkedList<>(data);
        Node root = new Node(inputQueue.poll());
        inputQueue.poll(); // 移除根节点后的null分隔符

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!inputQueue.isEmpty()) {
            Node current = nodeQueue.poll();
            List<Node> children = new ArrayList<>();
            while (!inputQueue.isEmpty() && inputQueue.peek() != null) {
                Integer val = inputQueue.poll();
                if (val != null) {
                    Node child = new Node(val);
                    children.add(child);
                    nodeQueue.offer(child);
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
    public static List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        for (Node child : node.children) {
            preorderHelper(child, result);
        }
    }

    // 后序遍历
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(Node node, List<Integer> result) {
        if (node == null) return;
        for (Node child : node.children) {
            postorderHelper(child, result);
        }
        result.add(node.val);
    }

    // 层序遍历
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;
    }

    // 查找节点
    public static Node findNode(Node root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        for (Node child : root.children) {
            Node found = findNode(child, target);
            if (found != null) return found;
        }
        return null;
    }

    // 计算树的高度
    public static int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    // 计算节点总数
    public static int countNodes(Node root) {
        if (root == null) return 0;
        int count = 1;
        for (Node child : root.children) {
            count += countNodes(child);
        }
        return count;
    }

    // 序列化N叉树
    public static List<Integer> serialize(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        result.add(root.val);
        result.add(null); // 根节点子节点开始标记
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node child : current.children) {
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
        Node root = buildTree(data);

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
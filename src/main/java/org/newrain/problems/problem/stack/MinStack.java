package org.newrain.problems.problem.stack;

import java.util.Stack;


/**
 * LeetCode.155 最小栈
 *
 * TODO 链表解法待研究
 * Node {
 * int val,
 * int min val, // 保存在该节点
 * Node next
 * }
 * 例如 1,2,3,4 一次入栈
 * node[1,1,null]->node[2,1,null]->node[3,1,null]->node[4,1,null]
 */
public class MinStack {

    private Stack<Integer> minStack; // 保存最小值
    private Stack<Integer> stack; // 正常入栈

    public MinStack() {
        minStack = new Stack<>();
        stack    = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // minStack 为空时 或者 当前的值小于栈顶值 则压入栈
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek(); // 返回当前最小值
    }


    public static void main(String[] args) {

    }

}
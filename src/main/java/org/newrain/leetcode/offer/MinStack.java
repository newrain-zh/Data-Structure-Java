package org.newrain.leetcode.offer;

import java.util.Stack;

/**
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();   --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {

    /**
     * stack1 用来正常保存栈的数据
     * stack2 用来保存数据非严格的数据的顺序。这样能保证statck1 在出栈时 stack2的有目前队列的最小值
     */
    private Stack<Integer> stack1, stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.add(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())) {
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}

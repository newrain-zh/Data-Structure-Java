package org.newrain.code.problem.stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    public Queue<Integer> mainQueue = new ArrayDeque<>(); // 主队列 维持栈的顺序 先进先出 栈顶元素在队列尾部
    public Queue<Integer> tempQueue = new ArrayDeque<>(); // 辅助队列

    public void push(int x) {
        tempQueue.offer(x);
        if (!mainQueue.isEmpty()) {
            while (!mainQueue.isEmpty()) {
                tempQueue.offer(mainQueue.poll());
            }
        }
        Queue<Integer> queue = mainQueue;
        mainQueue = tempQueue;
        tempQueue = queue;
    }

    public int pop() {
        if (mainQueue.isEmpty()) {
            return -1;
        }
        return mainQueue.poll();
    }

    public int top() { // 不移除
        // 获取队列头部元素
        Integer peek = mainQueue.peek();
        if (peek != null) {
            return peek;
        }
        return -1;
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.top());
    }
}
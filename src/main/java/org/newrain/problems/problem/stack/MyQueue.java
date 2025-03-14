package org.newrain.problems.problem.stack;

import java.util.Stack;

/**
 * Leetcode.232 用栈实现队列
 *
 * @author NewRain-zh
 */
public class MyQueue {


    public MyQueue() {

    }

    public Stack<Integer> mainStack = new Stack<>();
    public Stack<Integer> tempStack = new Stack<>();


    public void push(int x) {
        while (!mainStack.isEmpty()) { // 将主栈元素添加到辅助栈
            tempStack.push(mainStack.pop());
        }
        tempStack.push(x); // 然后将要添加的元素添加到辅助栈
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop()); // 然后将辅助栈元素添加到主栈
        }
/*        Stack<Integer> changeStack = mainStack;
        mainStack = tempStack;
        tempStack = changeStack;*/
    }

    // 从队列的开头移除并返回元素
    public int pop() {
        Integer pop = mainStack.pop();
        return pop != null ? pop : -1;
    }

    public int peek() {
        Integer peek = mainStack.peek();
        return peek != null ? peek : -1;
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.mainStack);
    }
}
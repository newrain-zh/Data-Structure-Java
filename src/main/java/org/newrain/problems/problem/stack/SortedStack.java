package org.newrain.problems.problem.stack;

import java.util.Stack;

public class SortedStack {

    private final Stack<Integer> main   = new Stack<>();
    private final Stack<Integer> helper = new Stack<>();

    public SortedStack() {
    }

    public void push(int val) {
        // 主栈中比 val 小的值 放入辅助栈
        while (!main.isEmpty() && main.peek() < val) { //
            helper.push(main.pop());
        }
        // 新元素放到主栈
        main.push(val);
        while (!helper.isEmpty()) {
            main.push(helper.pop());
        }
    }

    public int pop() {
        if (!main.isEmpty()) {
            return main.pop();
        }
        return -1;
    }

    public int peek() {
        if (main.isEmpty()) {
            return -1;
        }
        return main.peek();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public static void main(String[] args) {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(4);
        sortedStack.push(5);
        sortedStack.push(1);
        System.out.println(sortedStack);

        while (!sortedStack.isEmpty()) {
            int v = sortedStack.pop();
            System.out.println(v);

        }

    }
}
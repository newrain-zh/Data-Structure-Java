package org.newrain.code.offer;

import java.util.LinkedList;

public class CQueue {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;


    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
           if (stack1.isEmpty()){
               return -1;
           }
           while (!stack1.isEmpty()){
               Integer pop = stack1.pop();
               stack2.push(pop);
           }
            return stack2.pop();
        }
        return stack2.pop();
    }
}

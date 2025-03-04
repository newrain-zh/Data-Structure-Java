package org.newrain.code.problem.stack;


import java.util.Stack;

/**
 * @author NewRain
 * @description 验证栈序列
 * @link <a href="https://leetcode.cn/problems/validate-stack-sequences/">...</a>
 * @tag 栈和队列
 * @complexity middle
 */
public class LeetCode946 {


    // pushed = 1, 2, 3, 4, 5 <-入栈的顺序
    // popped = 4, 5, 3, 2, 1 <-出栈的顺序
    // 使用 Stack 来模拟 pushed数组的入栈顺序
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> opStack = new Stack<>();
        int popIndex = 0; // 当前正在判断的出栈序列下标
        for (int j : pushed) { // 遍历 pushed 模拟入栈操作
            opStack.push(j); // 入栈
            while (!opStack.isEmpty() && opStack.peek() == popped[popIndex]) { // 栈顶与队列头节点元素是否相等
                // 如果栈不为空且栈顶元素等于出栈序列当前元素
                opStack.pop(); // 将元栈顶元素出栈
                popIndex++;  // 弹出队列头部元素
            }
        }
        // 这里也可以用 popIndex == popped.length 说明出栈序列(popped)已经遍历完，此时栈为空，说明入栈序列与出栈序列匹配成功
        return opStack.isEmpty(); // 如果栈为空 说明入栈序列与队列的操作序列匹配成功
    }

    // validateStackSequences 方法上的优化
    // 用数组来替代 Stack
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int popIndex = 0;
        int top = -1; // 模拟栈顶的下标
        int length = pushed.length;
        int[] stack = new int[length]; // 用数组来模拟栈
        for (int j : pushed) {
            stack[++top] = j; // 入栈
            while (top >= 0 && popIndex < length && stack[top] == popped[popIndex]) {
                popIndex++;
                top--;
            }
        }
        // 这里也可以用 popIndex == popped.length 说明出栈序列(popped)已经遍历完，此时栈为空，说明入栈序列与出栈序列匹配成功
        // 如果匹配成功 top = -1  因为最后栈顶的索引为0 如果 索引0匹配 top-- 所以等于-1
        return popIndex == length;
    }

    public static void main(String[] args) {
        System.out.println(validateStackSequences2(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
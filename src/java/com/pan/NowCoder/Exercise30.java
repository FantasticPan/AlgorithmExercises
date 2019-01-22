package com.pan.NowCoder;

import java.util.Stack;

/**
 * 包含 min 函数的栈-面试思路-举例让抽象问题具体化
 * Created by FantasticPan on 2019/1/22.
 */
public class Exercise30 {

    //通过辅助栈，或者使用数组等其他数据结构
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> helpStack = new Stack<>();

    public void push(int node) {
        if (stack.isEmpty() || node < helpStack.peek()) {
            helpStack.push(node);
        } else {
            helpStack.push(helpStack.peek());
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        helpStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return helpStack.peek();
    }
}

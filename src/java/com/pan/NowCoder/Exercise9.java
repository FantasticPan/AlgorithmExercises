package com.pan.NowCoder;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * Created by FantasticPan on 2019/1/17.
 */
public class Exercise9 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //入队
    public void push(int node) {
        stack1.push(node);
    }

    //出队
    public int pop() {
        //必须要有判空操作
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}

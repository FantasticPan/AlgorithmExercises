package com.pan.NowCoder;

import java.util.Stack;

/**
 * 栈的压入、弹出序列-面试思路-举例让抽象具体化
 * Created by FantasticPan on 2019/1/22.
 */
public class Exercise31 {

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushA.length; i++) {
            //先压入一个元素
            stack.push(pushA[i]);
            while (j < popA.length && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}

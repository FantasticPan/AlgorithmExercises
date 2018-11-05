package com.pan.stack;

import java.util.Stack;

/**
 * Created by FantasticPan on 2018/11/5.
 */
public class QueueWithStack {

    private static Stack<Object> stack1 = new Stack<>();
    private static Stack<Object> stack2 = new Stack<>();

    /**
     * 加入队列中的元素只加入到栈1中
     *
     * @param item
     */
    public static void appendTail(Object item) {
        stack1.push(item);
        System.out.println("压入栈元素：" + item);
    }

    /**
     * 删除一个元素时，检查栈2是否为空，栈2不为空则弹出栈2栈顶元素
     * 栈2为空时，则把栈1中的元素全部弹出、压入到栈2中，然后从栈2的栈顶弹出元素
     */
    public static void deleteHead() {
        if (!stack2.empty()) {
            System.out.println("弹出栈元素："+stack2.pop());
        }else {
            if (stack1.empty()) {
                throw new RuntimeException("队列为空");
            }
            while (!stack1.empty()) {
                Object item = stack1.pop();
                stack2.push(item);
            }
        }
    }
}

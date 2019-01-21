package com.pan.NowCoder;

/**
 * 反转链表-鲁棒性
 * Created by FantasticPan on 2019/1/19.
 */
public class Exercise24 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        //方法1：自己思考的方法，使用栈
        //if (head == null) {
        //    return null;
        //}
        //ListNode node = head;
        //ListNode node1 = head;
        //Stack<Integer> stack = new Stack<>();
        //while (node != null) {
        //    stack.push(node.val);
        //    node = node.next;
        //}
        //
        //node1.val = stack.pop();
        //ListNode node2 = node1;
        //node1 = node1.next;
        //
        //while (!stack.isEmpty() && node1 != null) {
        //    node1.val = stack.pop();
        //    node1 = node1.next;
        //}
        //
        //return node2;

        //方法2：指针实现
        if (head == null) {
            return null;
        }

        ListNode reverseHead = null;
        ListNode pre = null;
        ListNode node = head;

        while (node != null) {
            ListNode next = node.next; //保留下一个节点
            if (next == null) {
                reverseHead = node;
            }
            node.next = pre; //在这里已经对node.next进行了更改，所以下面要注意
            pre = node;
            node = next; //不能写成node = node.next
        }
        return reverseHead;
    }
}

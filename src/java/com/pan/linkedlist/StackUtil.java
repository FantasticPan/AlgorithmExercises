package com.pan.linkedlist;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by FantasticPan on 2018/11/1.
 */
public class StackUtil {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 1.删除单链表中的指定节点
     * @param head
     * @param node
     */
    public static void deleteNode(Node head, Node node) {
        //删除尾节点，采用顺序查找找到尾节点的前一节点
        if (node.next == null) {
            while (head.next != node) {
                head = head.next;
            }
            head.next = null;
        }

        //要删除的节点是头节点
        else if (head == node) {
            head = null;
        }

        //要删除的节点是中间普通节点
        else {
            Node q = node.next;
            node.data = q.data;
            node.next = q.next;
        }
    }

    /**
     * 2.单链表中删除指定数值的节点方法一：利用栈
     * @param head
     * @param num
     * @return
     */
    public Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.data != num) {
                stack.push(head);
            }
            head = head.next;
        }
        //while循环结束，所有元素全部入栈

        //把栈中元素还原为链表，注意栈是先入后出
        while (!stack.isEmpty()) {
            stack
                    .peek() //返回栈的头部节点
                    .next = head;
            head = stack
                    .pop(); //返回栈的头部节点并删除
        }
        return head;
    }

    /**
     * 3.单链表中删除指定数值的节点方法二：不利用栈
     * @param head
     * @param num
     * @return
     */
    public Node removeValue2(Node head, int num) {
        while (head != null) {
            if (head.data != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.data == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 4.删除单链表中数值重复的节点
     * @param head
     */
    public void deleteDuplication(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.data);
        while (cur != null) {
            if (set.contains(cur.data)) {
                pre.next = cur.next;
            }else {
                set.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }
}

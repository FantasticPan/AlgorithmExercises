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
     *
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
     *
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
                    .peek() //返回栈顶元素
                    .next = head;
            head = stack
                    .pop(); //返回栈顶元素，并且将该栈顶元素出栈
        }
        return head;
    }

    /**
     * 3.单链表中删除指定数值的节点方法二：不利用栈
     *
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
     *
     * @param head
     */
    public void deleteDuplication(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;

        //添加头节点，重复节点永远不会删除头节点
        set.add(head.data);
        while (cur != null) {
            //存在，删除
            if (set.contains(cur.data)) {
                pre.next = cur.next;
            }
            //不存在，添加HashSet
            else {
                set.add(cur.data);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * 5.两个单链表生成相加链表
     * 前提：每一个节点里面只能存一个0-9的数字
     *
     * @param head1
     * @param head2
     * @return
     */
    public Node addList(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        //把链表1的所有元素压栈
        while (head1 != null) {
            stack1.push(head1.data);
            head1 = head1.next;
        }
        //把链表2的所有元素压栈
        while (head2 != null) {
            stack2.push(head2.data);
            head2 = head2.next;
        }
        int n1 = 0;//链表1的数值
        int n2 = 0;//链表2的数值
        int n = 0;//n1 + n2 + ca
        int ca = 0; //进位

        Node node = null; //当前节点
        Node pnode = null; //当前节点的前驱结点
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            node = new Node(n % 10);
            node.next = pnode;
            pnode = node;
            ca = n / 10;
        }
        if (ca == 1) {
            pnode = node;
            node = new Node(n / 10);
            node.next = pnode;
        }
        return node;
    }

    /**
     * 6.判断一个链表是否为回文结构
     * 通过栈，比对逆序和原序数值是否相同
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        //链表全部元素入栈
        while (cur != null) { //这里不是cur.next，不然最后一个节点没有入栈
            stack.push(cur);
            cur = cur.next;
        }
        while (head.next != null) {
            if (head.data != stack.pop().data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public Node removeLastKthNode(Node head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        Node p = head;
        for (int i = 0; i < k; i++) {
            if (p.next != null) {
                p = p.next;
            }else {
                return head;
            }
        }
    }
}

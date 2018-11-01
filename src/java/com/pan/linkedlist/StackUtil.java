package com.pan.linkedlist;

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

    //1.删除单链表中的指定节点
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

    //2.单链表中删除指定数值的节点方法一：利用栈
    //3.单链表中删除指定数值的节点方法二：不利用栈
}

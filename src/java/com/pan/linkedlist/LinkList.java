package com.pan.linkedlist;

/**
 * Created by FantasticPan on 2018/11/7.
 * 实现单向链表
 */
public class LinkList {

    private Node head;

    /**
     * 节点
     */
    private class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    /**
     * 添加元素
     *
     * @param data
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * 显示链表元素
     *
     * @param head
     */
    public void showList(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 2; i++) {
            linkList.add(i);
        }
        linkList.showList(linkList.head);
        System.out.println(linkList.head.data);
    }
}

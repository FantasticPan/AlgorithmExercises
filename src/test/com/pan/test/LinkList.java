package com.pan.test;

import org.junit.Test;

/**
 * Created by FantasticPan on 2018/11/7.
 * 实现一个链表
 */
public class LinkList {

    Integer a;

    private Node head;

    /**
     * 节点
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * 测试
     */
    @Test
    public void test() {
        System.out.println("作为");
    }
}

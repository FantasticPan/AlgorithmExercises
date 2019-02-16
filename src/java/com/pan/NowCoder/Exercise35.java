package com.pan.NowCoder;

/**
 * 分解让复杂问题简单-复杂链表的复制
 * Created by FantasticPan on 2019/2/16.
 */
public class Exercise35 {

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        //1、复制链表
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;

            currentNode = nextNode;
        }

        //2、
        //currentNode代表老节点
        currentNode = pHead;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表
        currentNode = pHead;
        RandomListNode cloneHead = pHead.next; //新的头节点，已经确定
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next; //构建原链表
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next; //构建新链表

            currentNode = currentNode.next; //因为原链表的下一个节点已经构建完成，所以currentNode.next得到的是原来链表的第二个节点
        }

        return cloneHead;
    }

}

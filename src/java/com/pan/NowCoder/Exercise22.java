package com.pan.NowCoder;

/**
 * 链表中倒数第k个节点-鲁棒性
 * Created by FantasticPan on 2019/1/19.
 */
public class Exercise22 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {

        //方法1：两次遍历实现
        //if (head == null) {
        //    return null;
        //}
        //
        //int i = 1;
        //ListNode head1 = head;
        //while (head1.next != null) {
        //    head1 = head1.next;
        //    i++;
        //}
        //
        //if (i < k) {
        //    return null;
        //}
        //
        //ListNode head2 = head;
        //for (int j = 1; j < i; j++) {
        //    if (j == (i - k + 1)) {
        //        head2 = head2.next;
        //        break;
        //    }
        //}
        //return head2;

        //方法2：一次遍历
        //定义两个指针，第一个指针先走k-1步，第k步开始，两个指针同时开始移动，当第一个指针达到最后一个节点时，第二个指针刚好在第k个节点
        if (head == null || k == 0) {
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        int i = 0;
        while (i < k - 1) {
            //加入if语句，判断特殊情况节点数少于k
            if (first.next != null) {
                first = first.next;
                i++;
            } else {
                return null;
            }
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}

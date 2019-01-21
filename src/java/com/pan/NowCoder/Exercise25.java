package com.pan.NowCoder;

/**
 * 合并两个排序的链表-鲁棒性
 * Created by FantasticPan on 2019/1/21.
 */
public class Exercise25 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        ListNode mergeHead = null;

        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = Merge(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = Merge(list1, list2.next);
        }
        return mergeHead;
    }
}

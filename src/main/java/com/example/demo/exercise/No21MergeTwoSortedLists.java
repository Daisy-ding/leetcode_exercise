package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/8 6:08 下午
 */
public class No21MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
            head.next = null;
        } else {
            head = l2;
            l2 = l2.next;
            head.next = null;
        }
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
                current = current.next;
                current.next = null;
            } else {
                current.next = l2;
                l2 = l2.next;
                current = current.next;
                current.next = null;
            }
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return head;
    }
}

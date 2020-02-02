package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/2 7:58 下午
 */
public class No19RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        for (ListNode current = head; current != null; current = current.next) {
            count++;
        }
        if (n < 1) {
            return null;
        }
        if (n > count) {
            return head;
        }
        if (n == count) {
            return head.next;
        }
        ListNode fast = head;
        int k = 0;
        while (k < n) {
            fast = fast.next;
            k++;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}

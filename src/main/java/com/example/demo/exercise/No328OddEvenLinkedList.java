package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/2 3:21 下午
 */
public class No328OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode headNext = head.next;
        ListNode odd = head;
        ListNode even = headNext;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            even.next = odd.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = headNext;

        return head;
    }
}

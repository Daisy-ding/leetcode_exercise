package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 5:23 下午
 */
public class No83RemoveDuplicatesFromSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                //Remove Duplicate Node
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

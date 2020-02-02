package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/2 8:51 下午
 */
public class No147InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode sortedNode = head;
        while (sortedNode.next != null) {
            ListNode firstUnsortedNode = sortedNode.next;
            if (sortedNode.val <= firstUnsortedNode.val) {
                sortedNode = firstUnsortedNode;
                continue;
            }
            if (firstUnsortedNode.val <= head.val) {
                sortedNode.next = firstUnsortedNode.next;
                firstUnsortedNode.next = head;
                head = firstUnsortedNode;
            } else {
                ListNode pointer = head;
                while (pointer.next != sortedNode && pointer.next.val <= firstUnsortedNode.val) {
                    pointer = pointer.next;
                }
                sortedNode.next = firstUnsortedNode.next;
                firstUnsortedNode.next = pointer.next;
                pointer.next = firstUnsortedNode;
            }
        }
        return head;
    }
}

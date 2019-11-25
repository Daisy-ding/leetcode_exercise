package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 10:53 下午
 */
public class No876MiddleOfTheLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            count++;
        }
        int half = count / 2;
        int i = 1;
        current = head;
        while (i < half) {
            current = current.next;
            i++;
        }
        return current;
    }
}

package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/8 10:28 下午
 */
public class No92ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m > 1) {
            return innerReserveBetween(head, m, n);
        } else {
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            fakeHead = innerReserveBetween(fakeHead, m + 1, n + 1);
            return fakeHead.next;
        }
    }

    private ListNode innerReserveBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode pointer = head;
        while (i < m - 1) {
            pointer = pointer.next;
            i++;
        }
        ListNode pre = pointer;
        // pointer is node m
        pointer = pointer.next;
        Stack<ListNode> stack = new Stack<>();
        while (i < n) {
            stack.push(pointer);
            pointer = pointer.next;
            i++;
        }
        ListNode post = pointer;

        pointer = pre;
        while (!stack.isEmpty()) {
            ListNode now = stack.pop();
            now.next = null;
            pointer.next = now;
            pointer = pointer.next;
        }
        pointer.next = post;

        return head;
    }

    public static void main(String[] args) {
        No92ReverseLinkedListII solution = new No92ReverseLinkedListII();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        first.next = second;

        solution.reverseBetween(first, 1, 2);
    }
}

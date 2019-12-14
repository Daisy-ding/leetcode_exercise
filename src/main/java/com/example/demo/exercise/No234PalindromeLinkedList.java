package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 11:46 上午
 */
public class No234PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        while (fast != null) {
            stack.push(slow.val);
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
                stack.pop();
            }
        }
        while (slow != null) {
            if (stack.isEmpty()) {
                return false;
            }
            Integer i = stack.pop();
            if (i != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

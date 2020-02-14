package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/2/1 2:32 下午
 */
public class No2AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int localResult = l1.val + l2.val;
        int lastCarry = localResult / 10;
        ListNode result = new ListNode(localResult % 10);
        ListNode lastNode = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            localResult = l1.val + l2.val + lastCarry;
            ListNode newNode = new ListNode(localResult % 10);
            lastNode.next = newNode;

            l1 = l1.next;
            l2 = l2.next;
            lastNode = newNode;
            lastCarry = localResult / 10;
        }
        while (l1 != null) {
            localResult = l1.val + lastCarry;
            ListNode newNode = new ListNode(localResult % 10);
            lastNode.next = newNode;

            l1 = l1.next;
            lastNode = newNode;
            lastCarry = localResult / 10;
        }
        while (l2 != null) {
            localResult = l2.val + lastCarry;
            ListNode newNode = new ListNode(localResult % 10);
            lastNode.next = newNode;

            l2 = l2.next;
            lastNode = newNode;
            lastCarry = localResult / 10;
        }
        if (lastCarry > 0) {
            ListNode newNode = new ListNode(lastCarry);
            lastNode.next = newNode;
        }
        return result;
    }
}

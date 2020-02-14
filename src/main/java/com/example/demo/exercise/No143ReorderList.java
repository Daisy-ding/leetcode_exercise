package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang
 * @date 2020/2/7 11:43 下午
 */
public class No143ReorderList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode pointer = head;
        Stack<ListNode> stack = new Stack<>();
        int count = 0;
        while (null != pointer) {
            stack.push(pointer);
            count++;
            pointer = pointer.next;
        }
        pointer = head;
        int i = 0;
        while (i < count / 2) {
            ListNode temp = pointer.next;
            ListNode end = stack.pop();
            if (temp == end) {
                temp.next = null;
                break;
            }
            end.next = temp;

            pointer.next = end;
            pointer = temp;
            i++;
        }
        if (count % 2 == 1) {
            pointer.next = null;
        }
    }

    public static void main(String[] args) {
        No143ReorderList solution = new No143ReorderList();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode forth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        solution.reorderList(first);
    }
}

package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/1 3:29 下午
 */
public class No445AddTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int lastCarry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int localResult = s1.pop() + s2.pop() + lastCarry;
            resultStack.push(localResult % 10);
            lastCarry = localResult / 10;
        }

        while (!s1.isEmpty()) {
            int localResult = s1.pop() + lastCarry;
            resultStack.push(localResult % 10);
            lastCarry = localResult / 10;
        }

        while (!s2.isEmpty()) {
            int localResult = s2.pop() + lastCarry;
            resultStack.push(localResult % 10);
            lastCarry = localResult / 10;
        }

        if (lastCarry > 0) {
            resultStack.push(lastCarry);
        }

        int rootValue = resultStack.pop();
        ListNode root = new ListNode(rootValue);
        ListNode lastNode = root;
        while (!resultStack.isEmpty()) {
            lastNode.next = new ListNode(resultStack.pop());
            lastNode = lastNode.next;
        }
        return root;
    }
}

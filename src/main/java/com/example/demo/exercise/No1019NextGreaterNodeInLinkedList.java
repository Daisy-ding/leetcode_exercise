package com.example.demo.exercise;

import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/6 10:50 下午
 */
public class No1019NextGreaterNodeInLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        int[] arr = new int[10000];
        int[] valueArr = new int[10000];
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        while (head != null) {
            int value = head.val;
            valueArr[length] = value;
            while (!stack.isEmpty() && value > valueArr[stack.peek()]) {
                arr[stack.pop()] = value;
            }
            stack.add(length++);
            head = head.next;
        }
        int[] result = new int[length];
        for (int i = 0; i < length; ++i) {
            result[i] = arr[i];
        }
        return result;
    }
}

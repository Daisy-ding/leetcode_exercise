package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/1 8:24 下午
 */
public class No237DeleteNodeInALinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

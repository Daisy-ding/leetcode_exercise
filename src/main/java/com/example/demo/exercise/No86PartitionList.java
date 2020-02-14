package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yubang
 * @date 2020/2/2 8:33 下午
 */
public class No86PartitionList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        Queue<ListNode> smallerQueue = new LinkedList<>();
        Queue<ListNode> largerQueue = new LinkedList<>();
        for (ListNode pointer = head; pointer != null; pointer = pointer.next) {
            if (pointer.val >= x) {
                largerQueue.add(pointer);
            } else {
                smallerQueue.add(pointer);
            }
        }
        ListNode result = smallerQueue.isEmpty() ? largerQueue.poll() : smallerQueue.poll();
        ListNode last = result;
        while (!smallerQueue.isEmpty()) {
            ListNode current = smallerQueue.poll();
            last.next = current;
            last = current;
        }
        while (!largerQueue.isEmpty()) {
            ListNode current = largerQueue.poll();
            last.next = current;
            last = current;
        }
        last.next = null;
        return result;
    }
}

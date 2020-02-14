package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/23 6:15 下午
 */
public class No61RotateList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int nodeLength(ListNode head) {
        int result = 1;
        while (head.next != null) {
            result++;
            head = head.next;
        }
        return result;
    }

    private List<ListNode> findLastTwoNodes(ListNode head) {
        ListNode lastSecond = head;
        ListNode last = lastSecond.next;
        if (last == null) {
            last = lastSecond;
        }
        while (last.next != null) {
            lastSecond = last;
            last = last.next;
        }
        List<ListNode> results = new ArrayList<>();
        results.add(lastSecond);
        results.add(last);
        return results;
    }

    private ListNode rotate(ListNode head, List<ListNode> results) {
        ListNode lastSecond = results.get(0);
        ListNode last = results.get(1);
        last.next = head;
        lastSecond.next = null;
        return last;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        int nodeLength = nodeLength(head);
        int rotationTimes = k % nodeLength;
        if (rotationTimes == 0) {
            return head;
        }
        for (int i = 0; i < rotationTimes; ++i) {
            List<ListNode> results = findLastTwoNodes(head);
            head = rotate(head, results);
        }
        return head;
    }
}

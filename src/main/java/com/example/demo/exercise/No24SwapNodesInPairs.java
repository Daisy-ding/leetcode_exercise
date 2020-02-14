package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/2 4:00 下午
 */
public class No24SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (null == head) {
            return null;
        }
        List<Integer> list = new LinkedList<>();

        ListNode fast = head;
        while (fast != null && fast.next != null) {
            list.add(fast.next.val);
            list.add(fast.val);

            fast = fast.next;
            fast = fast.next;
        }
        if (fast != null) {
            list.add(fast.val);
        }

        ListNode result = new ListNode(list.get(0));
        ListNode last = result;
        for (int i = 1; i < list.size(); ++i) {
            ListNode current = new ListNode(list.get(i));
            last.next = current;
            last = current;
        }
        return result;
    }
}

package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 6:22 下午
 */
public class No142LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (null == head) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //Has Circle
                ListNode entryNode = head;
                while (entryNode != slow) {
                    entryNode = entryNode.next;
                    slow = slow.next;
                }
                return entryNode;
            }
        }
        return null;
    }
}

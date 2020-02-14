package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang
 * @date 2020/2/2 7:38 下午
 */
public class No1171RemoveZeroSumConsecutiveNodesFromLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }

        int sum = 0;
        Map<Integer, ListNode> sumNodeMap = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            sum += current.val;
            sumNodeMap.put(sum, current);
            current = current.next;
        }

        sum = 0;
        current = head;
        while (current != null) {
            sum += current.val;

            ListNode node = sumNodeMap.get(sum);
            if (sum == 0) {
                head = node.next;
            }
            if (node != current) {
                current.next = node.next;
            }
            current = current.next;
        }
        return head;
    }
}

package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang
 * @date 2020/2/6 11:53 下午
 */
public class No160IntersectionOfTwoLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode pointer = headA;
        while (pointer != null) {
            set.add(pointer);
            pointer = pointer.next;
        }

        pointer = headB;
        while (pointer != null) {
            if (set.contains(pointer)) {
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }
}

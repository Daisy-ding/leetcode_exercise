package com.example.demo.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/9 10:06 下午
 */
public class No817LinkedListComponents {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }

        int result = 0;
        ListNode pointer = head;
        while (pointer != null) {
            if (set.contains(pointer.val)) {
                while (pointer != null && set.contains(pointer.val)) {
                    pointer = pointer.next;
                }
                result++;
            } else {
                pointer = pointer.next;
            }
        }
        return result;
    }
}

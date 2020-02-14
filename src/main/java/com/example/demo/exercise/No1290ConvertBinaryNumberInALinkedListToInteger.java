package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/15 6:48 下午
 */
public class No1290ConvertBinaryNumberInALinkedListToInteger {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        return Integer.valueOf(stringBuilder.toString(), 2);
    }
}

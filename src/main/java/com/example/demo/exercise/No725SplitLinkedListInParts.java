package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/2/2 2:47 下午
 */
public class No725SplitLinkedListInParts {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int count = 0;
        ListNode current = root;
        while (current != null) {
            count++;
            current = current.next;
        }
        int average = count / k;
        int addOneCount = count % k;
        ListNode[] results = new ListNode[k];

        current = root;
        for (int i = 0; i < k; ++i) {
            ListNode splitHead = current;
            if (i < addOneCount) {
                for (int j = 0; j < average; ++j) {
                    current = current.next;
                }
                if (current != null) {
                    ListNode temp = current.next;
                    current.next = null;
                    current = temp;
                }
            } else {
                for (int j = 0; j < average - 1; ++j) {
                    current = current.next;
                }
                if (current != null) {
                    ListNode temp = current.next;
                    current.next = null;
                    current = temp;
                }
            }
            results[i] = splitHead;
        }
        return results;
    }
}

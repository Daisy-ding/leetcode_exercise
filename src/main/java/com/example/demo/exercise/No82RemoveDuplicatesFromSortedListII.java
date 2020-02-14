package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/14 5:28 下午
 */
public class No82RemoveDuplicatesFromSortedListII {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            if (head.val == head.next.val) {
                return null;
            } else {
                return head;
            }
        }
        ListNode mockHead = new ListNode(0);
        mockHead.next = head;
        ListNode prev = mockHead;
        ListNode current = prev.next;
        while (current.next != null) {
            if (current.val == current.next.val) {
                int currentValue = current.val;
                while (current != null && current.val == currentValue) {
                    current = current.next;
                }
                if (current == null) {
                    prev.next = null;
                    break;
                } else {
                    prev.next = current;
                }
            } else {
                prev = prev.next;
                current = prev.next;
            }
        }
        return mockHead.next;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        String line = "[1,1,1,2,2,3,3]";
        ListNode head = stringToListNode(line);

        ListNode ret = new No82RemoveDuplicatesFromSortedListII().deleteDuplicates(head);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}

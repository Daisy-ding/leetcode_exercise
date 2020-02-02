package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/2 4:22 下午
 */
public class No138CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        current = head;
        Node newHead = head.next;
        Node newCurrent = newHead;
        while (current != null) {
            current.next = current.next.next;
            if (newCurrent.next != null) {
                newCurrent.next = newCurrent.next.next;
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }
}

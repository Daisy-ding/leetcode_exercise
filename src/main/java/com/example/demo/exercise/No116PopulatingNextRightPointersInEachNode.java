package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/9 11:36 下午
 */
public class No116PopulatingNextRightPointersInEachNode {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node level = root, worker = level, temp = level;
        while (level.left != null) {
            worker.left.next = worker.right;
            if (worker.next == null) {
                level = level.left;
                worker = level;
                temp = level;
            } else {
                worker.right.next = temp.next.left;
                worker = worker.next;
                temp = temp.next;
            }
        }
        return root;
    }
}

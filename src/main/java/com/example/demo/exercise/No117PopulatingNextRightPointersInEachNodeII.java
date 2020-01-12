package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/10 9:54 下午
 */
public class No117PopulatingNextRightPointersInEachNodeII {
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

    private Queue<Node> queue1 = new LinkedList<>();
    private Queue<Node> queue2 = new LinkedList<>();

    public Node connect(Node root) {
        if (null == root) {
            return root;
        }
        queue1.add(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                Node n = queue1.poll();
                n.next = queue1.peek();

                if (n.left != null) {
                    queue2.add(n.left);
                }
                if (n.right != null) {
                    queue2.add(n.right);
                }
            }

            while (!queue2.isEmpty()) {
                Node n = queue2.poll();
                n.next = queue2.peek();

                if (n.left != null) {
                    queue1.add(n.left);
                }
                if (n.right != null) {
                    queue1.add(n.right);
                }
            }
        }
        return root;
    }
}

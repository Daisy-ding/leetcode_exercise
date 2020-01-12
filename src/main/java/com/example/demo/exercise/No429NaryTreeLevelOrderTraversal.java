package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/10 11:18 下午
 */
public class No429NaryTreeLevelOrderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null) {
            return results;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> result = new LinkedList<>();
            int currentLength = queue.size();
            for (int i = 0; i < currentLength; ++i) {
                Node current = queue.poll();
                result.add(current.val);
                if (current.children != null) {
                    queue.addAll(current.children);
                }
            }
            results.add(result);
        }
        return results;
    }
}

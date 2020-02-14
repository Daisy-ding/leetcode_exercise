package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/24 3:07 下午
 */
public class No590NAryTreePostorderTraversal {
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

    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }
        for (Node node : root.children) {
            result.addAll(postorder(node));
        }
        result.add(root.val);
        return result;
    }
}

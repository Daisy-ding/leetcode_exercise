package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 3:07 下午
 */
public class No589NAryTreePreorderTraversal {
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

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (null == root) {
            return result;
        }
        result.add(root.val);
        for (Node node : root.children) {
            result.addAll(preorder(node));
        }
        return result;
    }
}

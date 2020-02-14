package com.example.demo.exercise;

import java.util.List;

/**
 * @author yubang
 * @date 2019/11/24 5:21 下午
 */
public class No559MaximumDepthOfNAryTree {
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

    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }
        if (root.children == null) {
            return 1;
        }
        int result = 1;
        int maxChildrenDepth = 0;
        for (Node node : root.children) {
            int depth = maxDepth(node);
            if (depth > maxChildrenDepth) {
                maxChildrenDepth = depth;
            }
        }
        result += maxChildrenDepth;
        return result;
    }
}

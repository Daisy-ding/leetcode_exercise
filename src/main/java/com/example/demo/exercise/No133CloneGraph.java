package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/2 9:49 下午
 */
public class No133CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node[] nodes = new Node[101];

    public Node cloneGraph(Node node) {
        if (null == node) {
            return null;
        }
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (nodes[node.val] != null) {
            return nodes[node.val];
        }
        Node newNode = new Node(node.val);
        List<Node> newNeighbors = new ArrayList<>();
        newNode.neighbors = newNeighbors;
        nodes[node.val] = newNode;

        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor));
        }
        return newNode;
    }
}

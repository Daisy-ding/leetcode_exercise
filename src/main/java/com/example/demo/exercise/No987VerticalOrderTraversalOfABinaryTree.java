package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 10:14 下午
 */
public class No987VerticalOrderTraversalOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Node {
        int x;
        int y;
        int val;

        public Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private Map<Integer, List<Node>> nodeListMap = new LinkedHashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        preOrderTravel(root, 0, 0);

        for (Integer key : nodeListMap.keySet()) {
            List<Node> nodeList = nodeListMap.get(key);
            nodeList.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.y == o2.y) {
                        return o1.val - o2.val;
                    }
                    return o1.y - o2.y;
                }
            });
        }
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> keys = new ArrayList<>(nodeListMap.keySet());
        keys.sort(Integer::compareTo);
        for (Integer key : keys) {
            List<Node> nodeList = nodeListMap.get(key);
            List<Integer> result = new ArrayList<>();
            for (Node node : nodeList) {
                result.add(node.val);
            }
            results.add(result);
        }
        return results;
    }

    private void preOrderTravel(TreeNode node, int x, int y) {
        if (node == null) {
            return;
        }
        if (!nodeListMap.containsKey(x)) {
            List<Node> nodeList = new ArrayList<>();
            nodeListMap.put(x, nodeList);
        }
        nodeListMap.get(x).add(new Node(x, y, node.val));

        preOrderTravel(node.left, x - 1, y + 1);
        preOrderTravel(node.right, x + 1, y + 1);
    }
}

package com.example.demo.exercise;

import java.util.*;

/**
 * @author yubang
 * @date 2020/1/13 11:33 下午
 */
public class No199BinaryTreeRightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> rightValueMap = new HashMap<>();
    private int maxDepth = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Integer> depthQueue = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);
        while (!nodeQueue.isEmpty()) {
            int depth = depthQueue.poll();
            TreeNode node = nodeQueue.poll();

            maxDepth = Math.max(maxDepth, depth);
            rightValueMap.put(depth, node.val);
            if (node.left != null) {
                nodeQueue.add(node.left);
                depthQueue.add(depth + 1);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
            }
        }
        List<Integer> results = new LinkedList<>();
        for (int i = 0; i <= maxDepth; ++i) {
            results.add(rightValueMap.get(i));
        }
        return results;
    }
}

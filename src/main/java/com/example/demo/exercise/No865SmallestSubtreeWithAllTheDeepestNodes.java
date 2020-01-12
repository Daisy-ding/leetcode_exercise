package com.example.demo.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/12 11:29 下午
 */
public class No865SmallestSubtreeWithAllTheDeepestNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<TreeNode, Integer> depthMap = new HashMap<>();
    private int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return answer(root);
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(maxDepth, depth);
        depthMap.put(node, depth);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    private TreeNode answer(TreeNode node) {
        if (node == null || depthMap.get(node) == maxDepth) {
            return node;
        }
        TreeNode left = answer(node.left);
        TreeNode right = answer(node.right);
        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}

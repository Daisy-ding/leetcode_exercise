package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/9 11:21 下午
 */
public class No1123LowestCommonAncestorOfDeepestLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode result;
    private int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        postOrderTravel(root, 0);
        return result;
    }

    private int postOrderTravel(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        depth++;
        int left = postOrderTravel(node.left, depth);
        int right = postOrderTravel(node.right, depth);
        depth = Math.max(left, right);
        if (left == right && depth >= maxDepth) {
            result = node;
            maxDepth = depth;
        }
        return depth;
    }
}

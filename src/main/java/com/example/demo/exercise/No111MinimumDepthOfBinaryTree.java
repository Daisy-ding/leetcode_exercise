package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 3:06 下午
 */
public class No111MinimumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int minDepth = Integer.MAX_VALUE;

    private void postOrderTravel(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, depth);
        }
        if (root.left != null) {
            postOrderTravel(root.left, depth + 1);
        }
        if (root.right != null) {
            postOrderTravel(root.right, depth + 1);
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrderTravel(root, 1);
        return minDepth;
    }
}

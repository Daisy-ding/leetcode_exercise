package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/8 4:40 下午
 */
public class No783MinimumDistanceBetweenBSTNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int minimumDiff = Integer.MAX_VALUE;
    private TreeNode preNode = null;

    private void inorderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravel(root.left);
        if (preNode != null) {
            minimumDiff = Math.min(minimumDiff, root.val - preNode.val);
        }
        preNode = root;
        inorderTravel(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        inorderTravel(root);
        return this.minimumDiff;
    }
}

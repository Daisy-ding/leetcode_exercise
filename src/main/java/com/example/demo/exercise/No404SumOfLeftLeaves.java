package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/10 12:20 上午
 */
public class No404SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int leftLeavesSum = 0;

    private void inorderTravel(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            inorderTravel(root.left);
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            leftLeavesSum += root.left.val;
        }
        if (root.right != null) {
            inorderTravel(root.right);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        inorderTravel(root);
        return leftLeavesSum;
    }
}

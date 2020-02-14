package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/21 1:09 上午
 */
public class No101SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return magic(root.left, root.right);
    }

    private boolean magic(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return (left.val == right.val) && magic(left.left, right.right) && magic(left.right, right.left);
    }
}

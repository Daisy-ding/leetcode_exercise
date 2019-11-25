package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 4:45 下午
 */
public class No965UnivaluedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean result;
        if (null != root.left) {
            result = (root.val == root.left.val) && isUnivalTree(root.left);
            if (!result) {
                return false;
            }
        }
        if (null != root.right) {
            result = (root.val == root.right.val) && isUnivalTree(root.right);
            if (!result) {
                return false;
            }
        }
        return true;
    }
}

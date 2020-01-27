package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/28 12:30 上午
 */
public class No98ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int value = node.val;
        if (lower != null && value <= lower) {
            return false;
        }
        if (upper != null && value >= upper) {
            return false;
        }
        if (!isValidBST(node.right, value, upper)) {
            return false;
        }
        if (!isValidBST(node.left, lower, value)) {
            return false;
        }
        return true;
    }
}

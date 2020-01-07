package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/7 11:04 下午
 */
public class No701InsertIntoABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val <= val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return root;
            } else {
                root.right = insertIntoBST(root.right, val);
                return root;
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return root;
            } else {
                root.left = insertIntoBST(root.left, val);
                return root;
            }
        }
    }
}

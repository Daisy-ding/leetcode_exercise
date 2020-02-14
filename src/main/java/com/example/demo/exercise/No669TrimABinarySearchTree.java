package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/29 11:31 下午
 */
public class No669TrimABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if (root.val < L) {
            root = root.right;
        } else if (root.val > R) {
            root = root.left;
        }
        return root;
    }
}

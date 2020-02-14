package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/4 10:49 下午
 */
public class No450DeleteNodeInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode curr = root.right;
            while (curr.left != null) {
                curr = curr.left;
            }

            curr.left = root.left;
            return root.right;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}

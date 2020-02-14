package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/23 1:37 上午
 */

public class No993CousinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findNode(TreeNode current, int parent, int x, int currentDepth) {
        if (current.val == x) {
            return new int[]{parent, currentDepth};
        }
        if (null != current.left) {
            int[] results = findNode(current.left, current.val, x, currentDepth + 1);
            if (null != results) {
                return results;
            }
        }
        if (null != current.right) {
            int[] results = findNode(current.right, current.val, x, currentDepth + 1);
            if (null != results) {
                return results;
            }
        }
        return null;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int[] rx = findNode(root, root.val, x, 1);
        int[] ry = findNode(root, root.val, y, 1);
        return (rx[0] != ry[0]) && (rx[1] == ry[1]);
    }
}

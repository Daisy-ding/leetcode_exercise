package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/18 11:17 下午
 */
public class No543DiameterOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getDepth(root.left);
        int R = getDepth(root.right);
        max = Math.max(L + R, max);
        return Math.max(L, R) + 1;
    }
}

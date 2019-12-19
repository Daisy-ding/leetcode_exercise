package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/18 11:31 下午
 */
public class No110BalancedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (help(root) == -1) {
            return false;
        }
        return true;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = help(root.left);
        int R = help(root.right);
        if (L == -1 || R == -1 || Math.abs(L - R) > 1) {
            return -1;
        } else {
            return Math.max(L, R) + 1;
        }
    }
}

package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/1 7:03 下午
 */
public class No572SubtreeOfAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean result = false;
        if (s.val == t.val) {
            if (isSameTree(s, t)) {
                return true;
            }
        }
        if (isSubtree(s.left, t)) {
            result = true;
        }
        if (isSubtree(s.right, t)) {
            result = true;
        }
        return result;
    }
}
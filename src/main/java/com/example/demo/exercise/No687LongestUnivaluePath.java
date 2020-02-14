package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/21 4:08 下午
 */
public class No687LongestUnivaluePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return result;
    }

    private int arrowLength(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        int arrowLeft = 0, arrowRight = 0;
        if (root.left != null && root.left.val == root.val) {
            arrowLeft += left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            arrowRight += right + 1;
        }
        result = Math.max(result, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}

package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/11 12:01 下午
 */
public class No1026MaximumDifferenceBetweenNodeAndAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, root.val);
        return result;
    }

    private void dfs(TreeNode node, int max, int min) {
        if (node == null) {
            return;
        }
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        if (node.left == null && node.right == null) {
            result = Math.max(result, Math.abs(max - min));
        }
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}

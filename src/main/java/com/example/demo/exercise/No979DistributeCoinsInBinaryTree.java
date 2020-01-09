package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/9 10:29 下午
 */
public class No979DistributeCoinsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node) {
        if (null == node) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        result += Math.abs(left) + Math.abs(right);
        return node.val + left + right - 1;
    }
}

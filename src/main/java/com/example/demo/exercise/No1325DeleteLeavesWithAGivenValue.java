package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/23 11:43 下午
 */
public class No1325DeleteLeavesWithAGivenValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int target;

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(node.val);
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }
        return node;
    }
}

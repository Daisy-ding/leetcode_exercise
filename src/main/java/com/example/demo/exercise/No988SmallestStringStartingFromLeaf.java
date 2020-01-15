package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/15 11:06 下午
 */
public class No988SmallestStringStartingFromLeaf {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private String result;

    public String smallestFromLeaf(TreeNode root) {
        this.result = null;
        if (root == null) {
            return this.result;
        }
        dfs(root, "");
        return this.result;
    }

    private void dfs(TreeNode node, String current) {
        if (node == null) {
            return;
        }
        String now = "" + (char) (node.val + 'a') + current;
        if (node.left == null && node.right == null) {
            if (result == null || now.compareTo(result) < 0) {
                result = now;
                return;
            }
        }
        dfs(node.left, now);
        dfs(node.right, now);
    }
}

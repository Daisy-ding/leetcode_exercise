package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/15 10:59 下午
 */
public class No129SumRootToLeafNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int currentValue) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += (currentValue * 10 + node.val);
            return;
        }
        currentValue = currentValue * 10 + node.val;
        dfs(node.left, currentValue);
        dfs(node.right, currentValue);
    }
}

package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/13 11:17 下午
 */
public class No1315SumOfNodesWithEvenValuedGrandparent {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null) {
                    sum += node.left.left.val;
                }
                if (node.left.right != null) {
                    sum += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    sum += node.right.left.val;
                }
                if (node.right.right != null) {
                    sum += node.right.right.val;
                }
            }
        }
        dfs(node.left);
        dfs(node.right);
    }
}

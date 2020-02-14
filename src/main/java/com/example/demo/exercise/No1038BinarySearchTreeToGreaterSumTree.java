package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/2/5 10:18 下午
 */
public class No1038BinarySearchTreeToGreaterSumTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        dfsSetUp(root, 0);
        return root;
    }

    private int dfsSetUp(TreeNode node, int parentSum) {
        if (null == node) {
            return parentSum;
        }
        int right = dfsSetUp(node.right, parentSum);
        node.val += right;

        return dfsSetUp(node.left, node.val);
    }
}

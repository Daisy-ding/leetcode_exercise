package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/4 10:32 下午
 */
public class No222CountCompleteTreeNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;

    public int countNodes(TreeNode root) {
        preOrderTravel(root);
        return count;
    }

    private void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        count++;
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }
}

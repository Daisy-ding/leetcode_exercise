package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/4 9:33 下午
 */
public class No1302DeepestLeavesSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int deepestLevel = 0;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        postOrderTravel(root, 0);
        return this.sum;
    }

    private void postOrderTravel(TreeNode node, int currentLevel) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.left, currentLevel + 1);
        postOrderTravel(node.right, currentLevel + 1);
        if (currentLevel > deepestLevel) {
            deepestLevel = currentLevel;
            sum = node.val;
        } else if (currentLevel == deepestLevel) {
            sum += node.val;
        }
    }
}

package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/19 12:25 上午
 */
public class No1161MaximumLevelSumOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxLevelSum = Integer.MIN_VALUE;
    private Queue<TreeNode> queue = new LinkedList<>();

    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return maxLevelSum;
        }
        queue.add(root);
        int lastCount = 1;
        int level = 0;
        int maxLevel = 0;
        do {
            int[] result = levelSum(lastCount);
            level++;
            if (result[0] > maxLevelSum) {
                maxLevelSum = result[0];
                maxLevel = level;
            }
            lastCount = result[1];
        } while (!queue.isEmpty());
        return maxLevel;
    }

    private int[] levelSum(int lastCount) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < lastCount; ++i) {
            TreeNode node = queue.poll();
            sum += node.val;
            if (node.left != null) {
                queue.add(node.left);
                count++;
            }
            if (node.right != null) {
                queue.add(node.right);
                count++;
            }
        }
        return new int[]{sum, count};
    }
}

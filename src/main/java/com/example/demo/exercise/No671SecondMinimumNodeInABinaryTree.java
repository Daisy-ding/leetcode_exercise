package com.example.demo.exercise;

import java.util.TreeSet;

/**
 * @author yubang
 * @date 2019/12/27 12:14 上午
 */
public class No671SecondMinimumNodeInABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeSet<Integer> minHeap = new TreeSet<>();

    private void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        minHeap.add(node.val);
        if (minHeap.size() > 2) {
            minHeap.remove(minHeap.last());
        }
        preOrderTravel(node.left);
        preOrderTravel(node.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        preOrderTravel(root);
        if (minHeap.size() != 2) {
            return -1;
        }
        return minHeap.last();
    }
}

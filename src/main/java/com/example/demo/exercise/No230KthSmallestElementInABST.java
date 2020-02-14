package com.example.demo.exercise;

import java.util.TreeSet;

/**
 * @author yubang
 * @date 2019/12/27 12:20 上午
 */
public class No230KthSmallestElementInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeSet<Integer> minHeap = new TreeSet<>();

    private void preOrderTravel(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        minHeap.add(node.val);
        if (minHeap.size() > k) {
            minHeap.remove(minHeap.last());
        }
        preOrderTravel(node.left, k);
        preOrderTravel(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        preOrderTravel(root, k);
        if (minHeap.size() != k) {
            return -1;
        }
        return minHeap.last();
    }
}

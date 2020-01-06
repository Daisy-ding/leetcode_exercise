package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/6 11:21 下午
 */
public class No1305AllElementsInTwoBinarySearchTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inOrderTravel(root1);
        inOrderTravel(root2);
        List<Integer> results = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            results.add(priorityQueue.remove());
        }
        return results;
    }

    private void inOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.left);
        priorityQueue.add(node.val);
        inOrderTravel(node.right);
    }
}

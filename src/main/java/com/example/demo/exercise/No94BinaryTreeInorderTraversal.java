package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/4 10:04 下午
 */
public class No94BinaryTreeInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> results = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTravel(root);
        return results;
    }

    private void inorderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        results.add(node.val);
        inorderTraversal(node.right);
    }
}

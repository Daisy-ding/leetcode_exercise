package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/12 11:28 下午
 */
public class No257BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<String> binaryTreePath = new LinkedList<>();

    private void preOrderTravelTree(TreeNode root, String lastPathString) {
        if (root == null) {
            return;
        }
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) {
            lastPathString += root.val;
            binaryTreePath.add(lastPathString);
        } else {
            lastPathString += (root.val + "->");
            preOrderTravelTree(root.left, lastPathString);
            preOrderTravelTree(root.right, lastPathString);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        preOrderTravelTree(root, "");
        return binaryTreePath;
    }
}

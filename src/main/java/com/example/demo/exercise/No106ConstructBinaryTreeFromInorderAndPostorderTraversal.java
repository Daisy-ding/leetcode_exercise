package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/15 10:12 下午
 */
public class No106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n != postorder.length || n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[n - 1]);
        if (n == 1) {
            return root;
        }
        int rootInorderIndex = 0;
        for (; rootInorderIndex < inorder.length; ++rootInorderIndex) {
            if (inorder[rootInorderIndex] == root.val) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, rootInorderIndex), Arrays.copyOfRange(postorder, 0, rootInorderIndex));
        root.right = buildTree(Arrays.copyOfRange(inorder, rootInorderIndex + 1, n), Arrays.copyOfRange(postorder, rootInorderIndex, n - 1));
        return root;
    }
}

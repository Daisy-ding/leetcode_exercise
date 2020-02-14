package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang
 * @date 2020/1/15 9:56 下午
 */
public class No105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n != inorder.length || n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (n == 1) {
            return root;
        }
        int rootInorderIndex = 0;
        for (; rootInorderIndex < inorder.length; ++rootInorderIndex) {
            if (inorder[rootInorderIndex] == root.val) {
                break;
            }
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootInorderIndex + 1), Arrays.copyOfRange(inorder, 0, rootInorderIndex));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootInorderIndex + 1, preorder.length), Arrays.copyOfRange(inorder, rootInorderIndex + 1, inorder.length));
        return root;
    }
}

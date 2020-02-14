package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/7 11:51 下午
 */
public class No538ConvertBSTToGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        convertBST(root.left);
        return root;
    }
}

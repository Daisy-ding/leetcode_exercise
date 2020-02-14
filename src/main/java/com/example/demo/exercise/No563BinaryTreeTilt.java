package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/20 11:54 下午
 */
public class No563BinaryTreeTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int tiltSum = 0;
        int leftSum = findSum(root.left);
        int rightSUm = findSum(root.right);
        int tiltRoot = Math.abs(leftSum - rightSUm);
        tiltSum += tiltRoot;
        return tiltSum + findTilt(root.left) + findTilt(root.right);
    }

    private int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + findSum(root.left) + findSum(root.right);
    }
}

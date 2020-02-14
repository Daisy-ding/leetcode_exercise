package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/23 7:55 下午
 */


public class No938RangeSumOfBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rangeSumBST(TreeNode root, int L, int R) {
        int result = 0;
        if (root.val >= L && root.val <= R) {
            result = root.val;
            if (root.left != null) {
                result += rangeSumBST(root.left, L, R);
            }
            if (root.right != null) {
                result += rangeSumBST(root.right, L, R);
            }
        } else if (root.val < L && root.right != null) {
            result += rangeSumBST(root.right, L, R);
        } else if (root.val > R && root.left != null) {
            result += rangeSumBST(root.left, L, R);
        }
        return result;
    }
}

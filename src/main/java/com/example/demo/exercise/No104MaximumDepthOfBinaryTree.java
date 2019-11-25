package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/24 5:21 下午
 */
public class No104MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int result = 1;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int maxChildrenDepth = leftDepth >= rightDepth ? leftDepth : rightDepth;

        result += maxChildrenDepth;
        return result;
    }
}

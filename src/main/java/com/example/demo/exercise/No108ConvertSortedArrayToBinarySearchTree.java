package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/7 8:44 下午
 */
public class No108ConvertSortedArrayToBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return new TreeNode(nums[startIndex]);
        }
        if (startIndex > endIndex) {
            return null;
        }
        if (startIndex < 0 || endIndex >= nums.length) {
            return null;
        }
        TreeNode treeNode = new TreeNode(nums[(endIndex + startIndex) / 2]);
        treeNode.left = sortedArrayToBST(nums, startIndex, (endIndex + startIndex) / 2 - 1);
        treeNode.right = sortedArrayToBST(nums, (endIndex + startIndex) / 2 + 1, endIndex);
        return treeNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
}

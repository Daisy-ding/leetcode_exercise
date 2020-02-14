package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/1/4 10:36 下午
 */
public class No1008ConstructBinarySearchTreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] nums;

    public TreeNode bstFromPreorder(int[] preorder) {
        this.nums = preorder;
        TreeNode root = construct(0, preorder.length - 1);
        return root;
    }

    private TreeNode construct(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(nums[left]);
        int mid = left + 1;
        while (mid <= right) {
            if (nums[mid] > nums[left]) {
                break;
            }
            mid++;
        }
        node.left = construct(left + 1, mid - 1);
        node.right = construct(mid, right);
        return node;
    }
}

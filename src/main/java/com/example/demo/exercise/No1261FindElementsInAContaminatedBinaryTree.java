package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/8 11:36 下午
 */
public class No1261FindElementsInAContaminatedBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode root;

    private void recover(TreeNode node, int expectVal) {
        if (node == null) {
            return;
        }
        node.val = expectVal;
        recover(node.left, 2 * expectVal + 1);
        recover(node.right, 2 * expectVal + 2);
    }

    private boolean find(TreeNode node, int target) {
        if (null == node) {
            return false;
        }
        if (node.val == target) {
            return true;
        }
        return find(node.left, target) || find(node.right, target);
    }

    public No1261FindElementsInAContaminatedBinaryTree(TreeNode root) {
        this.root = root;
        recover(root, 0);
    }

    public boolean find(int target) {
        return find(this.root, target);
    }
}

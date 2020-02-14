package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/24 9:53 下午
 */
public class No897IncreasingOrderSearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        preOrderTravel(root, vals);
        TreeNode head = new TreeNode(vals.get(0));
        TreeNode current = head;
        for (int i = 1; i < vals.size(); ++i) {
            TreeNode t = new TreeNode(vals.get(i));
            current.right = t;
            current = t;
        }
        return head;
    }

    public void preOrderTravel(TreeNode root, List<Integer> results) {
        if (null == root) {
            return;
        }
        if (null != root.left) {
            preOrderTravel(root.left, results);
        }
        results.add(root.val);
        if (null != root.right) {
            preOrderTravel(root.right, results);
        }
    }
}

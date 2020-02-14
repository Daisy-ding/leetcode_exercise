package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/26 12:41 上午
 */
public class No103BinaryTreeZigzagLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void preOrderTravel(TreeNode root, int level, List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        if (results.size() < (level + 1)) {
            List<Integer> newList = new LinkedList<>();
            newList.add(root.val);
            results.add(newList);
        } else {
            if (level % 2 == 0) {
                results.get(level).add(root.val);
            } else {
                results.get(level).add(0, root.val);
            }
        }
        if (root.left != null) {
            preOrderTravel(root.left, level + 1, results);
        }
        if (root.right != null) {
            preOrderTravel(root.right, level + 1, results);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        preOrderTravel(root, 0, results);
        return results;
    }
}

package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/26 11:02 下午
 */
public class No872LeafSimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leftLeafNodes = new LinkedList<>();
        List<Integer> rightLeafNodes = new LinkedList<>();
        leafTravel(root1, leftLeafNodes);
        leafTravel(root2, rightLeafNodes);
        if (leftLeafNodes.size() != rightLeafNodes.size()) {
            return false;
        }
        for (int i = 0; i < leftLeafNodes.size(); ++i) {
            if (!leftLeafNodes.get(i).equals(rightLeafNodes.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void leafTravel(TreeNode root, List<Integer> leafNodes) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafNodes.add(root.val);
        }
        if (root.left != null) {
            leafTravel(root.left, leafNodes);
        }
        if (root.right != null) {
            leafTravel(root.right, leafNodes);
        }
    }
}

package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 3:15 下午
 */
public class No515FindLargestValueInEachTreeRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> lists = new ArrayList<>();

    private void preOrderTravel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (lists.size() < (level + 1)) {
            lists.add(root.val);
        } else {
            lists.set(level, Math.max(lists.get(level), root.val));
        }
        if (root.left != null) {
            preOrderTravel(root.left, level + 1);
        }
        if (root.right != null) {
            preOrderTravel(root.right, level + 1);
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        preOrderTravel(root, 0);
        return lists;
    }
}

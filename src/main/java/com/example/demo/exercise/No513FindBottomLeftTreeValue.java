package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 3:23 下午
 */
public class No513FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxLevel = -1;
    private Integer result = null;

    private void preOrderTravel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            result = root.val;
            maxLevel = level;
        }
        preOrderTravel(root.left, level + 1);
        preOrderTravel(root.right, level + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        if (null == root) {
            return 0;
        }
        preOrderTravel(root, 0);
        return result;
    }
}

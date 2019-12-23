package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/21 4:02 下午
 */
public class No437PathSumIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return paths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int paths(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == sum) {
            result += 1;
        }
        result += paths(root.left, sum - root.val);
        result += paths(root.right, sum - root.val);

        return result;
    }
}

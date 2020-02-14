package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/12/21 3:42 下午
 */
public class No113PathSumII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> paths = new ArrayList<>();

    private void pathSum(TreeNode root, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                //Find A Valid Path
                paths.add(path);
            }
        }
        path.add(root.val);
        List<Integer> leftPath = new ArrayList<>(path);
        List<Integer> rightPath = new ArrayList<>(path);
        pathSum(root.left, leftPath, sum - root.val);
        pathSum(root.right, rightPath, sum - root.val);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        pathSum(root, path, sum);
        return paths;
    }
}

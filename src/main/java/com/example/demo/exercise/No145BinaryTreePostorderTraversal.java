package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/15 9:42 下午
 */
public class No145BinaryTreePostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<Integer> results = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return results;
        }
        dfs(root);
        return results;
    }

    private void dfs(TreeNode node) {
        if (null == node) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        results.add(node.val);
    }
}

package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang
 * @date 2020/1/10 11:02 下午
 */
public class No889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n = pre.length;
        if (n != post.length || n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (n == 1) {
            return root;
        }
        int leftNodeIndexInPre = 1;
        int postIndex = 0;
        for (; postIndex < post.length; ++postIndex) {
            if (post[postIndex] == pre[leftNodeIndexInPre]) {
                break;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, leftNodeIndexInPre, leftNodeIndexInPre + postIndex + 1), Arrays.copyOfRange(post, 0, postIndex + 1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, leftNodeIndexInPre + postIndex + 1, pre.length), Arrays.copyOfRange(post, postIndex + 1, post.length - 1));
        return root;
    }
}

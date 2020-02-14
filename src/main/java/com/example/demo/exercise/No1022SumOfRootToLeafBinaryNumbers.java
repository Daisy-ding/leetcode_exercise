package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2019/11/25 10:43 下午
 */
public class No1022SumOfRootToLeafBinaryNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void add(TreeNode node, String current, List<String> nodeBinaryList) {
        if (node == null) {
            return;
        }
        current += node.val;
        if (node.left == null && node.right == null) {
            nodeBinaryList.add(current);
        }
        if (node.left != null) {
            add(node.left, current, nodeBinaryList);
        }
        if (node.right != null) {
            add(node.right, current, nodeBinaryList);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        List<String> nodeBinaryList = new LinkedList<>();
        add(root, "", nodeBinaryList);
        for (String nodeBinary : nodeBinaryList) {
            result += Integer.valueOf(nodeBinary, 2);
        }
        return result;
    }
}

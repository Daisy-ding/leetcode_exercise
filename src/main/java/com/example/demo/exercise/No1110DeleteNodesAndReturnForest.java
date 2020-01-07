package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/7 11:34 下午
 */
public class No1110DeleteNodesAndReturnForest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<TreeNode> forest = new ArrayList<>();

    private TreeNode exists(TreeNode node, int deleteVal) {
        if (node == null) {
            return null;
        }
        if (node.val == deleteVal) {
            return node;
        }
        TreeNode leftFoundNode = exists(node.left, deleteVal);
        if (null != leftFoundNode) {
            return leftFoundNode;
        }
        TreeNode rightFoundNode = exists(node.right, deleteVal);
        if (null != rightFoundNode) {
            return rightFoundNode;
        }
        return null;
    }

    private void doDelete(TreeNode node, TreeNode toDeleteNode) {
        if (node == null) {
            return;
        }
        if (node == toDeleteNode) {
            forest.remove(node);
            if (node.left != null) {
                forest.add(node.left);
            }
            if (node.right != null) {
                forest.add(node.right);
            }
        } else {
            if (node.left == toDeleteNode) {
                node.left = null;
                if (toDeleteNode.left != null) {
                    forest.add(toDeleteNode.left);
                }
                if (toDeleteNode.right != null) {
                    forest.add(toDeleteNode.right);
                }
            } else if (node.right == toDeleteNode) {
                node.right = null;
                if (toDeleteNode.left != null) {
                    forest.add(toDeleteNode.left);
                }
                if (toDeleteNode.right != null) {
                    forest.add(toDeleteNode.right);
                }
            } else {
                doDelete(node.left, toDeleteNode);
                doDelete(node.right, toDeleteNode);
            }
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        forest.add(root);
        for (int deleteVal : to_delete) {
            for (TreeNode treeNode : forest) {
                TreeNode toDeleteNode = exists(treeNode, deleteVal);
                if (toDeleteNode != null) {
                    doDelete(treeNode, toDeleteNode);
                    break;
                }
            }
        }
        return forest;
    }
}

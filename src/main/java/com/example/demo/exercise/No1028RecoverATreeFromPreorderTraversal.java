package com.example.demo.exercise;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/1/27 11:31 下午
 */
public class No1028RecoverATreeFromPreorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class MultiNode {
        int value;
        int level;

        public MultiNode(int value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        List<MultiNode> nodes = new ArrayList<>();
        int firstIndex = S.indexOf('-');
        if (firstIndex == -1) {
            return new TreeNode(Integer.valueOf(S));
        }
        nodes.add(new MultiNode(Integer.valueOf(S.substring(0, firstIndex)), 0));
        int index = firstIndex;
        while (index < S.length()) {
            int count = 0;
            while (S.charAt(index) == '-') {
                count++;
                index++;
            }
            StringBuilder sb = new StringBuilder();
            while (index < S.length() && Character.isDigit(S.charAt(index))) {
                sb.append(S.charAt(index));
                index++;
            }
            nodes.add(new MultiNode(Integer.valueOf(sb.toString()), count));
        }

        return build(nodes);
    }

    private TreeNode build(List<MultiNode> nodes) {
        if (nodes == null || nodes.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(nodes.get(0).value);
        int firstChildIndex = 1;
        int secondChildIndex = 2;
        while (secondChildIndex < nodes.size()) {
            if (nodes.get(secondChildIndex).level == nodes.get(0).level + 1) {
                break;
            }
            secondChildIndex++;
        }
        if (firstChildIndex >= nodes.size()) {
            root.left = null;
        } else {
            root.left = build(nodes.subList(firstChildIndex, secondChildIndex));
        }
        if (secondChildIndex >= nodes.size()) {
            root.right = null;
        } else {
            root.right = build(nodes.subList(secondChildIndex, nodes.size()));
        }
        return root;
    }

    public static void main(String[] args) {
        No1028RecoverATreeFromPreorderTraversal solution = new No1028RecoverATreeFromPreorderTraversal();
        solution.recoverFromPreorder("1-2--3--4-5--6--7");
    }
}

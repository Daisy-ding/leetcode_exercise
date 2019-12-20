package com.example.demo.exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/21 12:01 上午
 */
public class No501FindModeInBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> elementCountMap = new LinkedHashMap<>();

    private void preOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        if (elementCountMap.containsKey(root.val)) {
            elementCountMap.put(root.val, elementCountMap.get(root.val) + 1);
        } else {
            elementCountMap.put(root.val, 1);
        }
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    public int[] findMode(TreeNode root) {
        preOrderTravel(root);

        Set<Integer> resultSet = new HashSet<>();
        int MAX = 0;
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            if (entry.getValue() > MAX) {
                MAX = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : elementCountMap.entrySet()) {
            if (entry.getValue() == MAX) {
                resultSet.add(entry.getKey());
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer value : resultSet) {
            result[i++] = value;
        }
        return result;
    }
}

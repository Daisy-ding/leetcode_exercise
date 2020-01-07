package com.example.demo.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/7 11:16 下午
 */
public class No508MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<Integer, Integer> sumCountMap = new HashMap<>();

    private int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sum(root.left) + root.val + sum(root.right);
    }

    private void inOrderTravel(TreeNode node) {
        if (null == node) {
            return;
        }
        inOrderTravel(node.left);
        int sum = sum(node);
        if (sumCountMap.containsKey(sum)) {
            sumCountMap.put(sum, sumCountMap.get(sum) + 1);
        } else {
            sumCountMap.put(sum, 1);
        }
        inOrderTravel(node.right);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        inOrderTravel(root);
        int maxSum = 0;
        for (Map.Entry<Integer, Integer> entry : sumCountMap.entrySet()) {
            maxSum = Math.max(maxSum, entry.getValue());
        }
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sumCountMap.entrySet()) {
            if (entry.getValue().intValue() == maxSum) {
                resultList.add(entry.getKey());
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); ++i) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}

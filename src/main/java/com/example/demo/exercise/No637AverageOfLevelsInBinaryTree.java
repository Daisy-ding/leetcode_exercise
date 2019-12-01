package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/30 3:01 下午
 */
public class No637AverageOfLevelsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void preOrderTravelTree(TreeNode root, int level, List<List<Integer>> valueList) {
        if (null == root) {
            return;
        }
        if (valueList.size() <= level) {
            List<Integer> values = new LinkedList<>();
            values.add(root.val);
            valueList.add(values);
        } else {
            valueList.get(level).add(root.val);
        }
        preOrderTravelTree(root.left, level + 1, valueList);
        preOrderTravelTree(root.right, level + 1, valueList);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> valueList = new LinkedList<>();
        preOrderTravelTree(root, 0, valueList);
        List<Double> results = new LinkedList<>();
        for (List<Integer> values : valueList) {
            Double sum = 0.0;
            for (Integer value : values) {
                sum += value;
            }
            results.add(sum / values.size());
        }
        return results;
    }
}

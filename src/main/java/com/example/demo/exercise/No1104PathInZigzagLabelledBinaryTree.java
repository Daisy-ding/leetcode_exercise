package com.example.demo.exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/9 12:12 上午
 */
public class No1104PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        int current = label;
        while (current > 0) {
            current = current / 2;
            level++;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(label);

        int shouldValue = label / 2;
        level = level - 1;
        while (level > 0) {
            int minLevelValue = (int) Math.pow(2, level - 1);
            int maxLevelValue = (int) Math.pow(2, level) - 1;

            boolean moreCloserWithMin = (shouldValue - minLevelValue) < (maxLevelValue - shouldValue);
            if (moreCloserWithMin) {
                shouldValue = maxLevelValue - (shouldValue - minLevelValue);
            } else {
                shouldValue = minLevelValue + (maxLevelValue - shouldValue);
            }
            stack.push(shouldValue);

            level--;
            shouldValue = shouldValue / 2;
        }

        List<Integer> result = new LinkedList<>();
        while (!stack.empty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        No1104PathInZigzagLabelledBinaryTree solution = new No1104PathInZigzagLabelledBinaryTree();
        List<Integer> result = solution.pathInZigZagTree(26);
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

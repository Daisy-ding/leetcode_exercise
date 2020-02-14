package com.example.demo.exercise;

import java.util.TreeSet;

/**
 * @author yubang
 * @date 2019/12/14 1:35 下午
 */
public class No453MinimumMovesToEqualArrayElements {
    private int[] maxIndex(int[] nums) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : nums) {
            treeSet.add(num);
        }
        if (treeSet.size() == 1) {
            return new int[]{-1, 0};
        } else {
            int max = treeSet.last();
            treeSet.remove(max);
            int subMax = treeSet.last();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == max) {
                    return new int[]{i, max - subMax};
                }
            }
        }
        return new int[]{-1, 0};
    }

    private int addDiff(int[] nums, int maxIndex, int diff) {
        for (int i = 0; i < nums.length; ++i) {
            if (i != maxIndex) {
                nums[i] += diff;
            }
        }
        return diff;
    }

    public int minMovesBruteForce(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[] results = maxIndex(nums);
        int maxIndex = results[0];
        int diff = results[1];
        if (maxIndex == -1) {
            return 0;
        }
        int count = 0;
        while (maxIndex != -1) {
            count += addDiff(nums, maxIndex, diff);
            results = maxIndex(nums);
            maxIndex = results[0];
            diff = results[1];
        }
        return count;
    }

    public int minMoves(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        int count = 0;
        for (int num : nums) {
            count += (num - min);
        }
        return count;
    }

    public static void main(String[] args) {
        No453MinimumMovesToEqualArrayElements solution = new No453MinimumMovesToEqualArrayElements();
        int[] nums = new int[]{1, 2, 3, 5};
        System.out.println(solution.minMoves(nums));
    }
}

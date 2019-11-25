package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/11/23 4:29 下午
 */
public class No416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1];
        }
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / 2;
        return knapsack(nums, target, target, nums.length - 1);
    }

    public boolean knapsack(int[] nums, int s1, int s2, int i) {
        if (i < 0) {
            return s1 == 0 && s2 == 0;
        }
        if (nums[i] > s1) {
            return knapsack(nums, s1, s2 - nums[i], i - 1);
        } else if (nums[i] > s2) {
            return knapsack(nums, s1 - nums[i], s2, i - 1);
        } else {
            return knapsack(nums, s1 - nums[i], s2, i - 1)
                    || knapsack(nums, s1, s2 - nums[i], i - 1);
        }
    }

    public static void main(String[] args) {
        No416PartitionEqualSubsetSum solution = new No416PartitionEqualSubsetSum();
        int[] inputs = new int[]{1, 5, 11, 5};
        System.out.println(solution.canPartition(inputs));
    }
}

package com.example.demo.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/1 12:59 上午
 */
public class No532KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        Set<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; ++i) {
            int target = nums[i] + k;
            int low = i + 1;
            int high = nums.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    targetSet.add(target);
                    break;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return targetSet.size();
    }

    public static void main(String[] args) {
        No532KDiffPairsInAnArray solution = new No532KDiffPairsInAnArray();
        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(solution.findPairs(nums, 2));
    }
}

package com.example.demo.exercise;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yubang
 * @date 2020/2/1 7:22 下午
 */
public class No18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> results = new LinkedList<>();
        if (nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int minSum = nums[0] + nums[1] + nums[2] + nums[3];
        int maxSum = nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4];
        if (target > maxSum || target < minSum) {
            return results;
        }
        for (int i = 0; i <= n - 4; ++i) {
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= n - 3; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int second = nums[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = first + second + nums[left] + nums[right];
                    if (sum > target) {
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    } else {
                        List<Integer> result = Arrays.asList(first, second, nums[left], nums[right]);
                        results.add(result);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        No18FourSum solution = new No18FourSum();
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> results = solution.fourSum(nums, 0);
        for (List<Integer> result : results) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

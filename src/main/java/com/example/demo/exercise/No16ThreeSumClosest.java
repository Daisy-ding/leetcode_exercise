package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/2/1 5:30 下午
 */
public class No16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < minDiff) {
                    minDiff = Math.abs(sum - target);
                    result = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        No16ThreeSumClosest solution = new No16ThreeSumClosest();
        int[] nums = {0, 2, 1, -3};
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}

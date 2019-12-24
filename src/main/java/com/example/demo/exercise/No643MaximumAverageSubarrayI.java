package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/24 11:10 下午
 */
public class No643MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        for (int i = 0; i < k; ++i) {
            maxSum += nums[i];
        }
        double currentSum = maxSum;
        for (int i = 1; i <= nums.length - k; ++i) {
            currentSum = currentSum - nums[i - 1] + nums[i + k - 1];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum / k;
    }
}

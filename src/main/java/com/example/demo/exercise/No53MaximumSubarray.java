package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/28 8:02 下午
 */
public class No53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {6, -2, 1, -3, 4, -1, 2, 1, -5, 4};
        No53MaximumSubarray solution = new No53MaximumSubarray();
        System.out.println(solution.maxSubArray(nums));
    }
}

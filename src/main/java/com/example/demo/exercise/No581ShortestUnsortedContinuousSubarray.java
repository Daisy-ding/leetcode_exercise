package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/26 10:25 下午
 */
public class No581ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        boolean leftMatch = true;
        boolean rightMatch = true;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (!leftMatch && !rightMatch) {
                break;
            }
            for (int k = i; k <= j; ++k) {
                if (nums[k] < nums[i]) {
                    leftMatch = false;
                }
                if (nums[k] > nums[j]) {
                    rightMatch = false;
                }
            }
            if (leftMatch) {
                i++;
            }
            if (rightMatch) {
                j--;
            }
        }
        return j == i ? 0 : j - i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 2};
        No581ShortestUnsortedContinuousSubarray solution = new No581ShortestUnsortedContinuousSubarray();
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}

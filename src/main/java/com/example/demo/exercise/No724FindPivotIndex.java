package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/15 6:00 下午
 */
public class No724FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int accumulate = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (accumulate == (sum - nums[i] - accumulate)) {
                return i;
            }
            accumulate += nums[i];
        }
        return -1;
    }
}

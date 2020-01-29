package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 8:34 下午
 */
public class No238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int lastZeroIndex = -1;
        int nonZeroProduct = 1;
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num == 0) {
                zeroCount++;
                lastZeroIndex = i;
            } else {
                nonZeroProduct *= num;
            }
        }
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; ++i) {
                if (i == lastZeroIndex) {
                    nums[i] = nonZeroProduct;
                } else {
                    nums[i] = 0;
                }
            }
        } else if (zeroCount > 1) {
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = 0;
            }
        } else {
            for (int i = 0; i < nums.length; ++i) {
                nums[i] = nonZeroProduct / nums[i];
            }
        }
        return nums;
    }
}

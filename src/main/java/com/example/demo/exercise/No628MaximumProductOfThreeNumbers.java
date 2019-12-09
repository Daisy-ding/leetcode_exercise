package com.example.demo.exercise;

import java.util.Arrays;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/9 12:33 上午
 */
public class No628MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int negativeCount = 0;
        int positiveCount = 0;
        boolean containZero = false;
        for (int num : nums) {
            if (num < 0) {
                negativeCount++;
            } else if (num == 0) {
                containZero = true;
            } else {
                positiveCount++;
            }
        }
        int maxThreeProduct = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        if (negativeCount == 0 || negativeCount == 1) {
            return maxThreeProduct;
        } else {
            //negativeCount >= 2
            if (positiveCount == 0) {
                return maxThreeProduct;
            } else {
                return Math.max(maxThreeProduct, nums[0] * nums[1] * nums[nums.length - 1]);
            }
        }
    }
}

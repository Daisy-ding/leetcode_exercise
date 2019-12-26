package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/27 12:09 上午
 */
public class No303RangeSumQueryImmutable {
    private int[] result;

    public No303RangeSumQueryImmutable(int[] nums) {
        result = nums;
        for (int i = 1; i < nums.length; ++i) {
            result[i] += result[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i <= j) {
            if (i > 0) {
                return result[j] - result[i - 1];
            } else {
                return result[j];
            }
        }
        return -1;
    }
}

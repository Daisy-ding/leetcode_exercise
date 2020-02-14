package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/9 12:47 上午
 */
public class No268MissingNumber {
    public int missingNumber(int[] nums) {
        boolean[] containArray = new boolean[nums.length + 1];
        for (int num : nums) {
            containArray[num] = true;
        }
        for (int i = 0; i <= nums.length; ++i) {
            if (!containArray[i]) {
                return i;
            }
        }
        return -1;
    }
}

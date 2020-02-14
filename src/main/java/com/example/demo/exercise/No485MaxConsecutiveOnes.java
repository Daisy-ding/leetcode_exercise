package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/4 3:06 上午
 */
public class No485MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                int j = i;
                int length = 0;
                while (j < nums.length && nums[j] == 1) {
                    j++;
                    length++;
                }
                if (length > result) {
                    result = length;
                }
                i = j;
            } else {
                i++;
            }
        }
        return result;
    }
}

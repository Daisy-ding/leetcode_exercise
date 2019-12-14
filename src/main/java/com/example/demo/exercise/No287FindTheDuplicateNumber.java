package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 6:36 下午
 */
public class No287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int[] bucket = new int[nums.length - 1];
        for (int num : nums) {
            if (bucket[num - 1] == 1) {
                return num;
            } else {
                bucket[num - 1] = 1;
            }
        }
        return 0;
    }
}

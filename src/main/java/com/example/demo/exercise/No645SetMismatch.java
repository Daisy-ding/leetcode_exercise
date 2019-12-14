package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/14 6:40 下午
 */
public class No645SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] bucket = new int[nums.length];
        int first = 0;
        int last = 0;
        for (int num : nums) {
            bucket[num - 1]++;
            if (bucket[num - 1] > 1) {
                first = num;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (bucket[i] == 0) {
                last = i + 1;
            }
        }
        return new int[]{first, last};
    }
}

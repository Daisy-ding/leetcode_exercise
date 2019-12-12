package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/12 11:53 下午
 */
public class No27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        int i = 0;
        while (i < count) {
            if (nums[i] == val) {
                for (int j = i; j < count - 1; ++j) {
                    nums[j] = nums[j + 1];
                }
                count--;
            } else {
                i++;
            }
        }
        return count;
    }
}

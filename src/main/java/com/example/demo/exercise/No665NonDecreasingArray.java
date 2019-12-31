package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/1 1:44 上午
 */
public class No665NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        boolean hasChange = false;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i] < nums[i - 1]) {
                if (hasChange) {
                    return false;
                } else {
                    if (i == nums.length - 1) {
                        nums[i] = nums[i - 1];
                        hasChange = true;
                    } else {
                        if (nums[i - 1] > nums[i + 1]) {
                            nums[i - 1] = nums[i];
                            hasChange = true;
                        } else {
                            nums[i] = nums[i - 1];
                            hasChange = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No665NonDecreasingArray solution = new No665NonDecreasingArray();
        int[] nums = {1, 5, 4, 6, 7, 10, 8, 9};
        System.out.println(solution.checkPossibility(nums));
    }
}

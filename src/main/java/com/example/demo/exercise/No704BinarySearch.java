package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/9 12:52 上午
 */
public class No704BinarySearch {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int bottom = 0;
        int top = nums.length - 1;
        if (target < nums[bottom] || target > nums[top]) {
            return -1;
        }
        while (bottom < top) {
            int mid = (bottom + top) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                top = mid - 1;
            } else if (nums[mid] < target) {
                bottom = mid + 1;
            }
        }
        if (nums[top] == target) {
            return top;
        }
        return -1;
    }
}

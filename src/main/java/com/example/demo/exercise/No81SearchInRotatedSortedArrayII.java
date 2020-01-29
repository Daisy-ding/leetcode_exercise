package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 5:23 下午
 */
public class No81SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int left = 0;
        int right = nums.length - 1;
        return findTarget(nums, left, right, target);
    }

    private boolean findTarget(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[left] < nums[right]) {
            if (nums[mid] > target) {
                return findTarget(nums, left, mid - 1, target);
            } else {
                return findTarget(nums, mid + 1, right, target);
            }
        } else {
            return findTarget(nums, left, mid - 1, target) ||
                    findTarget(nums, mid + 1, right, target);
        }
    }
}

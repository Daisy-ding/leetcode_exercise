package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2020/1/29 4:30 下午
 */
public class No33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        boolean rotated = true;
        if (nums[right] > nums[left]) {
            rotated = false;
        }
        if (!rotated) {
            return findTarget(nums, left, right, target);
        }
        int topIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                topIndex = mid;
                break;
            }
            if (nums[mid - 1] > nums[mid]) {
                topIndex = mid - 1;
                break;
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (topIndex == -1) {
            return -1;
        }
        if (target >= nums[0]) {
            return findTarget(nums, 0, topIndex, target);
        } else {
            return findTarget(nums, topIndex + 1, nums.length - 1, target);
        }
    }

    private int findTarget(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No33SearchInRotatedSortedArray solution = new No33SearchInRotatedSortedArray();
        int[] nums = {4, 5, 1, 2, 3};
        System.out.println(solution.search(nums, 1));
    }
}

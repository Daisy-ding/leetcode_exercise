package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/26 11:43 下午
 */
public class No35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                return i;
            }
            if (i != nums.length - 1) {
                if (nums[i] < target && nums[i + 1] > target) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        No35SearchInsertPosition solution = new No35SearchInsertPosition();
        System.out.println(solution.searchInsert(nums, 3));
    }
}

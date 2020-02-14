package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/12/29 10:13 上午
 */
public class No189RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
            return;
        }
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int newIndex = (i + k) % nums.length;
            newNums[newIndex] = nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = newNums[i];
        }
    }

    public static void main(String[] args) {
        No189RotateArray solution = new No189RotateArray();
        int[] nums = {-1, -100, 3, 99};
        solution.rotate(nums, 2);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

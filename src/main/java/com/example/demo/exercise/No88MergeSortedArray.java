package com.example.demo.exercise;

/**
 * @author yubang@alibaba-inc.com
 * @date 2019/12/27 12:30 上午
 */
public class No88MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                nums1[index--] = nums1[i--];
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                nums1[index--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        No88MergeSortedArray solution = new No88MergeSortedArray();
        int[] nums1 = {0};
        int[] nums2 = {1};
        solution.merge(nums1, 0, nums2, 1);
    }
}

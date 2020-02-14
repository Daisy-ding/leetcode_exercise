package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2019/11/29 11:41 下午
 */
public class No96NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] results = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            int target = nums1[i];
            int j = 0;
            for (j = 0; j < nums2.length; ++j) {
                if (nums2[j] == target) {
                    break;
                }
            }
            int result = -1;
            j++;
            while (j < nums2.length) {
                if (nums2[j] > target) {
                    result = nums2[j];
                    break;
                }
                j++;
            }
            results[i] = result;
        }
        return results;
    }
}

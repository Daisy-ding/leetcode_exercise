package com.example.demo.exercise;

/**
 * @author yubang
 * @date 2020/2/2 11:26 下午
 */
public class No75SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int sortedIndex = 0;
        while (sortedIndex < n - 1) {
            int unsortedIndex = sortedIndex + 1;
            if (nums[unsortedIndex] >= nums[sortedIndex]) {
                sortedIndex++;
            } else if (nums[unsortedIndex] <= nums[0]) {
                int temp = nums[unsortedIndex];
                for (int i = sortedIndex; i >= 0; i--) {
                    nums[i + 1] = nums[i];
                }
                nums[0] = temp;
                sortedIndex++;
            } else {
                int temp = nums[unsortedIndex];
                int k = 0;
                while (nums[k] <= nums[unsortedIndex]) {
                    k++;
                }
                for (int i = sortedIndex; i >= k; --i) {
                    nums[i + 1] = nums[i];
                }
                nums[k] = temp;
                sortedIndex++;
            }
        }
    }
}

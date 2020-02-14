package com.example.demo.exercise;

/**
 * @author yubang.cwt on 2020/2/13
 */
public class No80RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        int i = 0;
        while (i < result - 1) {
            if (nums[i] != nums[i + 1]) {
                i++;
                continue;
            }
            // nums[i] == nums[i+1]
            int j = i + 1;
            while (j < result) {
                if (nums[i] != nums[j]) {
                    break;
                }
                j++;
            }
            int count = j - i;
            if (count == 2) {
                i = j;
                continue;
            }

            // move now
            // j++ -> i++
            i = i + 2;
            int t = i;
            while (t < result && j < result) {
                nums[t++] = nums[j++];
            }
            result -= (count - 2);
        }
        return result;
    }

    public static void main(String[] args) {
        No80RemoveDuplicatesFromSortedArrayII solution = new No80RemoveDuplicatesFromSortedArrayII();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(solution.removeDuplicates(nums));
    }
}
